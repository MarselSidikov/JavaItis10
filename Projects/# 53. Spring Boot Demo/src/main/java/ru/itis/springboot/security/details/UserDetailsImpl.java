package ru.itis.springboot.security.details;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.itis.springboot.models.User;
import ru.itis.springboot.models.enums.UserState;

import java.util.Collection;
import java.util.Collections;

// класс, реализация UserDerails для Spring Security
// данный класс адаптирует нашего пользователя
// под архитектуру Spring Security
// то есть, Spring Security всегда работает
// с объектом, у которого есть поведение интерфейса UserDetails
public class UserDetailsImpl implements UserDetails {
    // поле, которое хранит нашего пользователя
    private User user;

    public User getUser() {
        return user;
    }

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    // метод, который возвращает список возможностей (authority) для пользователя
    // в нашем случае авторити соответствует роли пользователя
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().toString());
        return Collections.singleton(authority);
    }

    // метод для получения пароля ( в нашем случае хеш)
    @Override
    public String getPassword() {
        return user.getHashPassword();
    }

    // метод для получения имени пользователя (в нашем случае - логин)
    @Override
    public String getUsername() {
        return user.getLogin();
    }

    // аккаунт не просрочен
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // аккаунт не заблокирован
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // данные авторизации пользователя не просрочены
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // аккаунт активен - в нашем случае, аккаунт активен
    // если у него стоит статус - подтвержден
    @Override
    public boolean isEnabled() {
        return user.getState().equals(UserState.CONFIRMED);
    }
}
