package ru.itis.service.app;

import ru.itis.service.models.User;
import ru.itis.service.repositories.UsersRepository;
import ru.itis.service.repositories.UsersRepositoryJdbcImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class MainUsersRepositoryJdbcImpl {
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "qwerty007";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/java_120";
    public static void main(String[] args) throws Exception {
        Connection connection =
                DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(connection);
        List<User> users = usersRepository.findAll();
        System.out.println(users);
    }
}
