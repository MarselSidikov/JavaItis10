package ru.itis;

import junit.framework.AssertionFailedError;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Optional;
import java.util.Properties;

import static org.junit.Assert.*;

public class UsersRepositoryTest {

    private UsersRepository usersRepository;

    private static final User USER_1 = User.builder()
            .id(1L)
            .firstName("Марсель")
            .lastName("Сидиков")
            .login("marsel")
            .age(25)
            .build();

    @Before
    public void setUp() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("src\\test\\resources\\test_db.properties"));

        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.user");
        String password = properties.getProperty("db.password");
        Connection connection = DriverManager.getConnection(url, user, password);
        this.usersRepository = new UsersRepository(connection);
    }

    @Test
    public void testFindOneById() {
        Optional<User> userOptional = usersRepository.findOneById(1L);

        if (userOptional.isPresent()) {
            User actual = userOptional.get();
            assertEquals(USER_1, actual);
        } else {
            throw new AssertionFailedError("Empty user");
        }
    }
}