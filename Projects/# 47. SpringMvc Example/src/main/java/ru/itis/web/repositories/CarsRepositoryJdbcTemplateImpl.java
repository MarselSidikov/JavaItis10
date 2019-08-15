package ru.itis.web.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import ru.itis.web.models.Car;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Component(value = "cars.repository.jdbc.template.impl")
public class CarsRepositoryJdbcTemplateImpl implements CarsRepository {

    //language=SQL
    private static final String SQL_FIND_ALL_BY_OWNER_ID = "select * from car where owner_id = ?;";

    //language=SQL
    private static final String SQL_INSERT_CAR = "insert into car(model, number, owner_id) values (?, ?, ?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Car> carRowMapper = (row, rowNumber) -> Car.builder()
            .id(row.getLong("id"))
            .model(row.getString("model"))
            .number(row.getString("number"))
            .build();

    @Override
    public List<Car> findAllByUser_Id(Long userId) {
        return jdbcTemplate.query(SQL_FIND_ALL_BY_OWNER_ID, carRowMapper, userId);
    }

    @Override
    public Optional<Car> findOneById(Long id) {
        return Optional.empty();
    }

    @Override
    public Car save(Car model) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(SQL_INSERT_CAR, new String[]{"id"});
            statement.setString(1, model.getModel());
            statement.setString(2, model.getNumber());
            statement.setLong(3, model.getOwner().getId());
            return statement;
        }, keyHolder);

        model.setId(keyHolder.getKey().longValue());
        return model;
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
