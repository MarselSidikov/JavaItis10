package ru.itis.web.services;

import ru.itis.web.forms.SignInForm;
import ru.itis.web.forms.SignUpForm;
import ru.itis.web.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    void signUp(SignUpForm form);
    Optional<String> signIn(SignInForm form);
    Optional<UserDto> getUserByCookie(String cookie);
    List<UserDto> getAllUsers();
}
