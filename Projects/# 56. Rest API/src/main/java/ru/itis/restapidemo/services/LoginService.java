package ru.itis.restapidemo.services;

import ru.itis.restapidemo.dto.TokenDto;
import ru.itis.restapidemo.forms.UserCredentialsForm;

public interface LoginService {
    TokenDto login(UserCredentialsForm form);
}
