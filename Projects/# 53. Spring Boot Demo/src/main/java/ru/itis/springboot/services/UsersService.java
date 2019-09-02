package ru.itis.springboot.services;

import ru.itis.springboot.dto.UserDto;
import ru.itis.springboot.forms.SignInForm;
import ru.itis.springboot.forms.SignUpForm;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    void signUp(String uuid, SignUpForm form);
    List<UserDto> getAllUsers();

    void emailConfirm(String email);

    boolean isNotValidUUID(String uuid);
}
