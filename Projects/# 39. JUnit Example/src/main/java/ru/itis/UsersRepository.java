package ru.itis;

import java.sql.Connection;
import java.util.Optional;

public class UsersRepository {
    private Connection connection;
    private JdbcUtil jdbcUtil;

    //language=SQL
    private final static String SQL_SELECT_ONE_BY_ID = "select * from service_user where id = ?;";

    public UsersRepository(Connection connection) {
        this.connection = connection;
        this.jdbcUtil = new JdbcUtil(connection);
    }

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
                    .build();

    public Optional<User> findOneById(Long id) {
        return jdbcUtil.findOneById(SQL_SELECT_ONE_BY_ID, id, baseUserRowMapper);
    }
}
