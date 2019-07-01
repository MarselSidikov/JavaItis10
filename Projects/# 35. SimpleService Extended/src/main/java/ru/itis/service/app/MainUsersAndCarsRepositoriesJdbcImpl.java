package ru.itis.service.app;

import ru.itis.service.models.User;
import ru.itis.service.models.UserRole;
import ru.itis.service.repositories.CarsRepository;
import ru.itis.service.repositories.CarsRepositoryJdbcImpl;
import ru.itis.service.repositories.UsersRepository;
import ru.itis.service.repositories.UsersRepositoryJdbcImpl;

import javax.management.relation.Role;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Optional;

public class MainUsersAndCarsRepositoriesJdbcImpl {
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "qwerty007";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/java_120";
    public static void main(String[] args) throws Exception {
        Connection connection =
                DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(connection);
        CarsRepository carsRepository = new CarsRepositoryJdbcImpl(connection);
        List<User> users = usersRepository.findAll();
//        System.out.println(users);

        Optional<User> userCandidate = usersRepository.findOneById(3L);

        if (userCandidate.isPresent()) {
            System.out.println(userCandidate.get());
        } else {
            System.out.println("такого пользователя нет");
        }

        User user = User.builder()
                .login("kirill")
                .password("qwerty007")
                .role(UserRole.MODERATOR)
                .age(28)
                .firstName("Кирилл")
                .lastName("Беляев")
                .build();

        System.out.println(user);
        usersRepository.save(user);
        System.out.println(user);
        System.out.println(carsRepository.findOneById(2L));
        System.out.println(carsRepository.findOneById(1L));
    }
}
