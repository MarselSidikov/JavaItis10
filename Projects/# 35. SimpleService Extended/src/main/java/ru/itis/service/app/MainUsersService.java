package ru.itis.service.app;

import ru.itis.service.dto.SignUpForm;
import ru.itis.service.repositories.UsersRepository;
import ru.itis.service.repositories.UsersRepositoryJdbcImpl;
import ru.itis.service.services.UsersService;

import java.sql.Connection;
import java.sql.DriverManager;

public class MainUsersService {
    private static final String DB_USER = "postgres";

    private static final String DB_PASSWORD = "qwerty007";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/java_120";

    public static void main(String[] args) throws Exception {
        Connection connection =
                DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(connection);

        UsersService service = new UsersService(usersRepository);

        SignUpForm form = new SignUpForm();
        form.setLogin("igor");
        form.setPassword("igor007");
        service.signUp(form);
    }
}
