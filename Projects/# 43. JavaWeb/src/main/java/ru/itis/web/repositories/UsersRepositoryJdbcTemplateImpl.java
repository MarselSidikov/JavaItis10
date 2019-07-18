package ru.itis.web.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.web.models.User;

import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    private JdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<User> userRowMapper = (row, rowNumber) -> User.builder()
            .id(row.getLong("id"))
            .login(row.getString("login"))
            .password(row.getString("password"))
            .firstName(row.getString("first_name"))
            .lastName(row.getString("last_name"))
            .age(row.getInt("age"))
            .phone(row.getString("phone"))
            .email(row.getString("email"))
            .build();

    @Override
    public Optional<User> findOneByLogin(String login) {
        return Optional.empty();
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
        return jdbcTemplate.query("select * from service_user", userRowMapper);
    }
}
