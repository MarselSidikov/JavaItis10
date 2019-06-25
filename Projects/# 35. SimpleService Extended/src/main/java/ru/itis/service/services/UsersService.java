package ru.itis.service.services;

import ru.itis.service.dto.SignUpForm;
import ru.itis.service.models.User;
import ru.itis.service.models.UserRole;
import ru.itis.service.repositories.UsersRepository;

public class UsersService {

    private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User signUp(SignUpForm form) {
        User user = User.builder()
                .password(form.getPassword())
                .login(form.getLogin())
                .role(UserRole.USER)
                .build();
        usersRepository.save(user);
        return user;
    }
}
