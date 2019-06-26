package ru.itis.service.app;

import ru.itis.service.models.User;
import ru.itis.service.repositories.UsersRepository;
import ru.itis.service.repositories.UsersRepositoryFileBasedImpl;

import java.util.List;
import java.util.Optional;

public class MainUsersRepositoryFileBasedImpl {

    public static void main(String[] args) {
        UsersRepository usersRepository = new UsersRepositoryFileBasedImpl("users.txt");
	    List<User> users = usersRepository.findAll();
        System.out.println(users);

        Optional<User> userOptional = usersRepository.findOneById(4L);
        Optional<User> userOptional2 = usersRepository.findOneById(10L);

        if (userOptional.isPresent()) {
            System.out.println(userOptional.get());
        } else {
            System.out.println("Пользователь не найден");
        }
    }
}
