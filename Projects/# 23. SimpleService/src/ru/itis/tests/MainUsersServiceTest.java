package ru.itis.tests;

import ru.itis.dto.SignUpForm;
import ru.itis.models.User;
import ru.itis.repositories.IdGenerator;
import ru.itis.repositories.UsersRepository;
import ru.itis.services.UsersService;

import java.util.Arrays;

public class MainUsersServiceTest {
    public static void main(String[] args) {
        IdGenerator idGenerator = new IdGenerator("users_id.txt");
        UsersRepository usersRepository = new UsersRepository("users.txt", idGenerator);
        UsersService service = new UsersService(usersRepository);
//        SignUpForm form = new SignUpForm("marsel", "qwerty007");
//        User user = service.signUp(form);
//        System.out.println(user);

        User users[] = usersRepository.findAll();
        System.out.println(Arrays.toString(users));
    }
}
