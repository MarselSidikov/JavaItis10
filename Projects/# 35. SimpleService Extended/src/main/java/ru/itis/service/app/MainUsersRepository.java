package ru.itis.service.app;

import ru.itis.service.models.User;
import ru.itis.service.repositories.UsersRepository;
import ru.itis.service.repositories.UsersRepositoryJdbcImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Optional;

public class MainUsersRepository {
    private static final String DB_USER = "postgres";

    private static final String DB_PASSWORD = "qwerty007";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/java_120";
    public static void main(String[] args) throws Exception {
        Connection connection =
                DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(connection);

        Optional<User> userOptional = usersRepository.findOneById(2L);
//        System.out.println(userOptional.get());

        System.out.println(usersRepository.findAll());
    }
}
