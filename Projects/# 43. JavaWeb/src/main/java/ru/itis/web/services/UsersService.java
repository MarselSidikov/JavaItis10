package ru.itis.web.services;

import ru.itis.web.dto.SignInForm;
import ru.itis.web.dto.SignUpForm;
import ru.itis.web.dto.UserDto;
import ru.itis.web.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    void signUp(SignUpForm form);
    Optional<String> signIn(SignInForm form);
    Optional<User> getUserByCookie(String cookie);
    List<UserDto> getAllUsers();
}
