package ru.itis.services;

import ru.itis.dto.SignUpForm;
import ru.itis.models.User;
import ru.itis.models.UserRole;
import ru.itis.repositories.UsersRepository;

public class UsersService {

    private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User signUp(SignUpForm form) {
//        User.Builder myBuilder = new User.Builder();
        User user = User.builder()
                .password(form.getPassword())
                .login(form.getLogin())
                .role(UserRole.USER)
                .build();
        usersRepository.save(user);
        return user;
    }
}
