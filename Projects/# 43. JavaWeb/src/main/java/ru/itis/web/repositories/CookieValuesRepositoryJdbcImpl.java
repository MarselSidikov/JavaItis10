package ru.itis.web.repositories;

import ru.itis.web.models.CookieValue;
import ru.itis.web.models.User;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class CookieValuesRepositoryJdbcImpl implements CookieValuesRepository {

    //language=SQL
    private static final String SQL_INSERT_COOKIE = "insert  into cookie(value, user_id) values (?, ?)";

    //language=SQL
    private static final String SQL_FIND_BY_VALUE = "select c.value, su.* " +
            "from cookie c " +
            "       join service_user su on c.user_id = su.id " +
            "where c.value = ?;";

    private Connection connection;

    public CookieValuesRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    private RowMapper<CookieValue> cookieValueRowMapper = row -> {
        User user = UsersRepositoryJdbcImpl.baseUserRowMapper.mapRow(row);
        return CookieValue.builder()
                .value(row.getString("value"))
                .user(user)
                .build();
    };

    @Override
    public Optional<CookieValue> findOneById(Long id) {
        return Optional.empty();
    }

    @Override
    public CookieValue save(CookieValue model) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_COOKIE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, model.getValue());
            statement.setLong(2, model.getUser().getId());

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
        return model;
    }

    @Override
    public void update(CookieValue model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<CookieValue> findAll() {
        return null;
    }

    @Override
    public Optional<CookieValue> findOneByValue(String value) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_VALUE);
            statement.setString(1, value);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(cookieValueRowMapper.mapRow(resultSet));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
