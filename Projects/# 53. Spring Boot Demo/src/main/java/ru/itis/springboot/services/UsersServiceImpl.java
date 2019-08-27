package ru.itis.springboot.services;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.springboot.dto.UserDto;
import ru.itis.springboot.forms.SignInForm;
import ru.itis.springboot.forms.SignUpForm;
import ru.itis.springboot.models.CookieValue;
import ru.itis.springboot.models.User;
import ru.itis.springboot.models.enums.UserRole;
import ru.itis.springboot.models.enums.UserState;
import ru.itis.springboot.repositories.CookieValuesRepository;
import ru.itis.springboot.repositories.UsersRepository;

import java.io.StringWriter;
import java.util.*;

import static ru.itis.springboot.dto.UserDto.from;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CookieValuesRepository cookieValuesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    @Value("${mail.confirm.subject}")
    private String subject;

    @Value("${server.url}")
    private String serverUrl;

    @Autowired
    private Template confirmMailTemplate;

    @Transactional
    @Override
    public void signUp(String uuid, SignUpForm form) {

        User user = usersRepository.findByConfirmUUID(uuid);

        cookieValuesRepository.deleteAllByUser(user);

        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setLogin(form.getLogin());
        user.setRole(UserRole.USER);
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setState(UserState.CONFIRMED);
        user.setConfirmUUID(null);

        usersRepository.save(user);
    }

    @Transactional
    @Override
    public Optional<String> signIn(SignInForm form) {
        Optional<User> userCandidate = usersRepository.findByLogin(form.getLogin());

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
        Optional<CookieValue> cookieValueCandidate = cookieValuesRepository.findByValue(cookie);
        if (cookieValueCandidate.isPresent()) {
            CookieValue cookieValue = cookieValueCandidate.get();
            User user = cookieValue.getUser();
            if (user.getState().equals(UserState.CONFIRMED)) {
                return Optional.of(from(user));
            } else {
                return Optional.empty();
            }
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = usersRepository.findAll();
        return from(users);
    }

    @SneakyThrows
    @Override
    public void emailConfirm(String email) {

        Optional<User> user = usersRepository.findByEmail(email);

        User newUser;

//        if (user.isPresent()) {
//            newUser = user.get();
//        } else {
//            newUser = User.builder()
//                    .email(email)
//                    .build();
//        }

        newUser = user.orElseGet(() -> User.builder()
                .email(email)
                .build());

        newUser.setState(UserState.NOT_CONFIRMED);
        newUser.setConfirmUUID(UUID.randomUUID().toString());

        usersRepository.save(newUser);

        Runnable confirmMailTask = () -> {
            Map<String, Object> placeholders = new HashMap<>();
            placeholders.put("host", serverUrl);
            placeholders.put("id", newUser.getConfirmUUID());

            StringWriter stringWriter = new StringWriter();
            try {
                confirmMailTemplate.process(placeholders, stringWriter);

            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
            String mailText = stringWriter.toString();

            emailService.sendEmail(newUser.getEmail(), subject, mailText);
        };

        Thread confirmMailThread = new Thread(confirmMailTask);
        confirmMailThread.start();
    }

    @Override
    public boolean isValidUUID(String uuid) {
        return usersRepository.existsByConfirmUUID(uuid);
    }
}
