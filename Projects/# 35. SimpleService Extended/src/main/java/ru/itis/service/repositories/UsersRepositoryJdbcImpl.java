package ru.itis.service.repositories;

import ru.itis.service.models.User;
import ru.itis.service.models.UserRole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {

    //language=SQL
    private final static String SQL_FIND_ALL = "select * from service_user";

    private Connection connection;

    private RowMapper<User> userRowMapper = row -> {

        User user = User.builder()
                .id(row.getLong("id"))
                .login(row.getString("login"))
                .password(row.getString("password"))
                .firstName(row.getString("first_name"))
                .lastName(row.getString("last_name"))
                .age(row.getInt("age"))
                .role(UserRole.valueOf(row.getString("role")))
                .phone(row.getString("phone"))
                .email(row.getString("email"))
                .build();

        return user;
    };

    public UsersRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<User> findOneById(Long id) {
        return Optional.empty();
    }

    @Override
    public User save(User model) {
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
            List<User> result = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL);

            while (resultSet.next()) {
                User user = userRowMapper.mapRow(resultSet);
                result.add(user);
            }

            return result;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
