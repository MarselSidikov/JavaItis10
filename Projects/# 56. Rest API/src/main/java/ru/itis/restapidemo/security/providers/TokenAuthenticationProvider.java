package ru.itis.restapidemo.security.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import ru.itis.restapidemo.models.Token;
import ru.itis.restapidemo.repositories.TokensRepository;
import ru.itis.restapidemo.security.authentication.TokenAuthentication;

import java.util.Optional;

@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private TokensRepository tokensRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Optional<Token> tokenOptional = tokensRepository.findByValue(authentication.getName());
        TokenAuthentication tokenAuthentication = (TokenAuthentication)authentication;
        if (tokenOptional.isPresent()) {
            Token token = tokenOptional.get();
            tokenAuthentication.setUser(token.getUser());
            tokenAuthentication.setAuthenticated(true);
        } else {
            throw new AuthenticationCredentialsNotFoundException("Invalid token");
        }
        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return TokenAuthentication.class.equals(authentication);
    }
}
