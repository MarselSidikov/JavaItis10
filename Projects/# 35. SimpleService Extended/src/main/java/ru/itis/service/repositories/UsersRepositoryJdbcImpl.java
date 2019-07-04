package ru.itis.service.repositories;

import ru.itis.service.models.Car;
import ru.itis.service.models.User;
import ru.itis.service.models.UserRole;
import ru.itis.service.utils.jdbc.JdbcUtil;

import java.sql.*;
import java.util.*;

public class UsersRepositoryJdbcImpl implements UsersRepository {

    //language=SQL
    private final static String SQL_SELECT_ALL = "select su.*, c.id as car_id, c.model " +
            "from service_user su " +
            "       left join car c on su.id = c.owner_id;";

    //language=SQL
    private final static String SQL_SELECT_ONE_BY_ID = "select su.*, c.id as car_id, c.model " +
            "from service_user su " +
            "       left join car c on su.id = c.owner_id " +
            "where su.id = ?;";

    //language=SQL
    private final static String SQL_INSERT_USER = "insert into " +
            "service_user (first_name, last_name, age, phone, email, login, password, role) " +
            "values (?, ?, ?, ?, ?, ?, ?, ?);";

    private Connection connection;

    private JdbcUtil jdbcUtil;

    private Map<Long, User> userMap;

    private static RowMapper<User> baseUserRowMapper = row ->
        User.builder()
                .id(row.getLong("id"))
                .login(row.getString("login"))
                .password(row.getString("password"))
                .firstName(row.getString("first_name"))
                .lastName(row.getString("last_name"))
                .age(row.getInt("age"))
                .role(UserRole.valueOf(row.getString("role")))
                .phone(row.getString("phone"))
                .email(row.getString("email"))
                .cars(new ArrayList<>())
                .build();

    private static RowMapper<Car> userCarRowMapper = row ->
            Car.builder()
                    .id(row.getLong("car_id"))
                    .model(row.getString("model"))
                    .build();

    static RowMapper<User> userWithCarsRowMapper = row -> {
        User user = baseUserRowMapper.mapRow(row);

        row.getLong("car_id");

        if (!row.wasNull()) {
            Car car = userCarRowMapper.mapRow(row);
            user.getCars().add(car);

            while (row.next()) {
                car = userCarRowMapper.mapRow(row);
                user.getCars().add(car);
            }
        }

        return user;
    };

    private RowMapper<User> usersWithCarsRowMapper = row -> {
        Long userId = row.getLong("id");
        // если в мапе не было такого пользователя
        if (!userMap.containsKey(userId)) {
            User user = baseUserRowMapper.mapRow(row);
            userMap.put(userId, user);
        }

        row.getLong("car_id");

        if (!row.wasNull()) {
            Car car = userCarRowMapper.mapRow(row);
            userMap.get(userId).getCars().add(car);
        }

        return null;

    };

    public UsersRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
        this.jdbcUtil = new JdbcUtil(connection);
    }

    @Override
    public Optional<User> findOneById(Long id) {
        return jdbcUtil.findOneById(SQL_SELECT_ONE_BY_ID, id, userWithCarsRowMapper);
    }

    @Override
    public User save(User model) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, model.getFirstName());
            statement.setString(2, model.getLastName());
            statement.setObject(3, model.getAge());
            statement.setString(4, model.getPhone());
            statement.setString(5, model.getEmail());
            statement.setString(6, model.getLogin());
            statement.setString(7, model.getPassword());
            statement.setString(8, model.getRole().toString());

            int affectedRows = statement.executeUpdate();

            if (affectedRows != 1) {
                throw new IllegalArgumentException();
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                model.setId(generatedKeys.getLong("id"));
            } else throw new IllegalArgumentException();

        } catch (SQLException e) {
            throw new IllegalArgumentException();
        }
        return null;
    }

    @Override
    public void update(User model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<User> findAll() {
        try {
            userMap = new HashMap<>();

            List<User> result;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);

            while (resultSet.next()) {
                usersWithCarsRowMapper.mapRow(resultSet);
            }

            result = new ArrayList<>(userMap.values());

            return result;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
