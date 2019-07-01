package ru.itis.service.repositories;

import ru.itis.service.models.Car;
import ru.itis.service.models.User;
import ru.itis.service.utils.jdbc.JdbcUtil;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class CarsRepositoryJdbcImpl implements CarsRepository {

    //language=SQL
    private static final String SQL_SELECT_ONE_BY_ID = "select c.id as car_id, c.model, su.* " +
            "from car c " +
            "       left join service_user su on c.owner_id = su.id " +
            "where c.id = ?;";

    private Connection connection;

    private JdbcUtil jdbcUtil;

    public CarsRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
        this.jdbcUtil = new JdbcUtil(connection);
    }

    private RowMapper<Car> carRowMapper = row -> {

        row.getLong("id");
        User user = null;
        if (!row.wasNull()) {
            user = UsersRepositoryJdbcImpl.userWithCarsRowMapper.mapRow(row);
        }

        return Car.builder()
                .id(row.getLong("car_id"))
                .model(row.getString("model"))
                .owner(user)
                .build();
    };
    @Override
    public List<Car> findAllByOwner(User owner) {
        return null;
    }

    @Override
    public Optional<Car> findOneById(Long id) {
        return jdbcUtil.findOneById(SQL_SELECT_ONE_BY_ID, id, carRowMapper);
    }

    @Override
    public Car save(Car model) {
        return null;
    }

    @Override
    public void update(Car model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Car> findAll() {
        return null;
    }
}
