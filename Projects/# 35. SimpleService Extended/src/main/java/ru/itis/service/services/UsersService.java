package ru.itis.service.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.service.dto.SignUpForm;
import ru.itis.service.models.User;
import ru.itis.service.models.UserRole;
import ru.itis.service.repositories.UsersRepository;

public class UsersService {

    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User signUp(SignUpForm form) {
        User user = User.builder()
                .password(passwordEncoder.encode(form.getPassword()))
                .login(form.getLogin())
                .role(UserRole.USER)
                .build();
        usersRepository.save(user);
        return user;
    }
}
