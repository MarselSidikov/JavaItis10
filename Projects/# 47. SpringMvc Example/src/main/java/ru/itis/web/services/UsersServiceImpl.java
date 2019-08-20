package ru.itis.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.web.forms.SignInForm;
import ru.itis.web.forms.SignUpForm;
import ru.itis.web.dto.UserDto;
import ru.itis.web.models.CookieValue;
import ru.itis.web.models.User;
import ru.itis.web.models.UserRole;
import ru.itis.web.repositories.CookieValuesRepository;
import ru.itis.web.repositories.UsersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static ru.itis.web.dto.UserDto.from;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    @Qualifier(value = "users.repository.jpa.impl")
    private UsersRepository usersRepository;

    @Autowired
    @Qualifier(value = "cookie.values.repository.jpa.impl")
    private CookieValuesRepository cookieValuesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void signUp(SignUpForm form) {
        User user = User.builder()
                .password(passwordEncoder.encode(form.getPassword()))
                .login(form.getLogin())
                .role(UserRole.USER)
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .build();
        usersRepository.save(user);
    }

    @Transactional
    @Override
    public Optional<String> signIn(SignInForm form) {
        Optional<User> userCandidate = usersRepository.findOneByLogin(form.getLogin());

        if (userCandidate.isPresent()) {
            User user = userCandidate.get();
            if (passwordEncoder.matches(form.getPassword(), user.getPassword())) {
                CookieValue cookieValue = CookieValue.builder()
                        .value(UUID.randomUUID().toString())
                        .user(user)
                        .build();
                cookieValuesRepository.save(cookieValue);
                return Optional.of(cookieValue.getValue());
            }
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<UserDto> getUserByCookie(String cookie) {
        Optional<CookieValue> cookieValueCandidate = cookieValuesRepository.findOneByValue(cookie);
        if (cookieValueCandidate.isPresent()) {
            CookieValue cookieValue = cookieValueCandidate.get();
            User user = cookieValue.getUser();
            return Optional.of(from(user));
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = usersRepository.findAll();
        return from(users);
    }
}
