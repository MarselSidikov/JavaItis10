package ru.itis.app;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new DriverManagerDataSource("jdbc:postgresql://localhost:5432/java_120",
                "postgres", "qwerty007");
        JdbcTemplate template = new JdbcTemplate(dataSource);

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

        List<User> users = template.query("select * from service_user", userRowMapper);
        System.out.println(users);

        User user = template.queryForObject("select * from service_user su where su.id = ?", userRowMapper, 2);
        System.out.println(user);

        user.setEmail("oleg_in_l@mail.ru");
        template.update("update service_user set email = ? where service_user.id = ?;", user.getEmail(),
                user.getId());

        User newUser = User.builder()
                .age(26)
                .email("ilya@gmail.com")
                .firstName("Илья")
                .lastName("Иванов")
                .login("ilya")
                .build();


        KeyHolder keyHolder = new GeneratedKeyHolder();

        template.update(con -> {
            PreparedStatement statement = con.prepareStatement("insert into service_user (first_name, last_name, age, login, email) " +
                    "values (?, ?, ?, ?, ?);", new String[]{"id"});
            statement.setString(1, newUser.getFirstName());
            statement.setString(2, newUser.getLastName());
            statement.setInt(3, newUser.getAge());
            statement.setString(4, newUser.getLogin());
            statement.setString(5, newUser.getEmail());
            return statement;
        }, keyHolder);

        newUser.setId(keyHolder.getKey().longValue());

        System.out.println(newUser);
    }

}
