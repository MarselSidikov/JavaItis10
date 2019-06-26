package ru.itis.service.repositories;

import ru.itis.service.models.User;
import ru.itis.service.models.UserRole;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryFileBasedImpl implements UsersRepository {

    private String fileName;

    private StringsRowMaper<User> userRowMapper = line -> {
        String userData[] = line.split("\\|");
        String idString = userData[0];
        String firstName = userData[1];
        String lastName = userData[2];
        String ageAsString = userData[3];
        String phone = userData[4];
        String email = userData[5];
        String login = userData[6];
        String password = userData[7];
        UserRole role = UserRole.valueOf(userData[8]);

        User user = User.builder()
                .id(Long.parseLong(idString))
                .login(login)
                .password(password)
                .build();

        if (!firstName.equals("null")) {
            user.setFirstName(firstName);
        }

        if (!lastName.equals("null")) {
            user.setLastName(lastName);
        }

        if (!ageAsString.equals("null")) {
            user.setAge(Integer.parseInt(ageAsString));
        }

        user.setRole(role);

        return user;
    };

    public UsersRepositoryFileBasedImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Optional<User> findOneById(Long id) {
        try {
            Reader reader = new FileReader(fileName);
            BufferedReader bufferedReader
                    = new BufferedReader(reader);

            String currentUserLine = bufferedReader.readLine();
            while (currentUserLine != null) {
                User user = userRowMapper.mapRow(currentUserLine);

                if (user.getId().equals(id)) {
                    return Optional.of(user);
                }

                currentUserLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }

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
        List<User> result = new ArrayList<>();
        try {
            Reader reader = new FileReader(fileName);
            BufferedReader bufferedReader
                    = new BufferedReader(reader);

            String currentUserLine = bufferedReader.readLine();
            while (currentUserLine != null) {
                User user = userRowMapper.mapRow(currentUserLine);
                result.add(user);
                currentUserLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }

        return result;
    }
}
