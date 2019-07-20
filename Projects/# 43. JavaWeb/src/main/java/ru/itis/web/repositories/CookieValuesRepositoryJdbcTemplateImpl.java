package ru.itis.web.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.itis.web.models.CookieValue;
import ru.itis.web.models.User;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class CookieValuesRepositoryJdbcTemplateImpl implements CookieValuesRepository {

    //language=SQL
    private static final String SQL_FIND_BY_VALUE = "select c.value, su.* " +
            "from cookie c " +
            "       join service_user su on c.user_id = su.id " +
            "where c.value = ?;";

    //language=SQL
    private static final String SQL_INSERT_COOKIE = "insert  into cookie(value, user_id) values (?, ?)";

    private JdbcTemplate jdbcTemplate;

    private RowMapper<CookieValue> cookieValueRowMapper = (row, rowNumber) -> {
        User user = UsersRepositoryJdbcTemplateImpl.userRowMapper.mapRow(row, rowNumber);
        return CookieValue.builder()
                .value(row.getString("value"))
                .user(user)
                .build();
    };

    public CookieValuesRepositoryJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<CookieValue> findOneByValue(String value) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_FIND_BY_VALUE, cookieValueRowMapper, value));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<CookieValue> findOneById(Long id) {
        return Optional.empty();
    }

    @Override
    public CookieValue save(CookieValue model) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(SQL_INSERT_COOKIE, new String[]{"id"});
            statement.setString(1, model.getValue());
            statement.setLong(2, model.getUser().getId());
            return statement;
        }, keyHolder);

        model.setId(keyHolder.getKey().longValue());
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
}
