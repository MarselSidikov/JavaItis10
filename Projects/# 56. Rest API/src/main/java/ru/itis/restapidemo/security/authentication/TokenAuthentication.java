package ru.itis.restapidemo.security.authentication;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ru.itis.restapidemo.models.User;

import java.util.Collection;
import java.util.Collections;

public class TokenAuthentication implements Authentication {

    // токен, который выдали пользователю
    private String token;
    // сам пользователь
    private User user;
    // флаг, аутентифицирован он или нет
    private boolean isAuthenticated;

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return user;
    }

    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.isAuthenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return token;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
