package ru.itis.restapidemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.restapidemo.dto.TokenDto;
import ru.itis.restapidemo.forms.UserCredentialsForm;
import ru.itis.restapidemo.models.Token;
import ru.itis.restapidemo.models.User;
import ru.itis.restapidemo.repositories.TokensRepository;
import ru.itis.restapidemo.repositories.UsersRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TokensRepository tokensRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public TokenDto login(UserCredentialsForm form) {
        Optional<User> userOptional = usersRepository.findByEmail(form.getEmail());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(form.getPassword(), user.getHashPassword())) {
                Token token = Token.builder()
                        .user(user)
                        .value(UUID.randomUUID().toString())
                        .build();
                tokensRepository.save(token);
                return TokenDto.builder()
                        .token(token.getValue())
                        .id(user.getId())
                        .build();
            } else {
                throw new BadCredentialsException("Incorrect email or password");
            }
        } else {
            throw new BadCredentialsException("Incorrect email or password");
        }
    }
}
