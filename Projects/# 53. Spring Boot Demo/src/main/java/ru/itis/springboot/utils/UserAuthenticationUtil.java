package ru.itis.springboot.utils;

import org.springframework.stereotype.Component;
import ru.itis.springboot.dto.UserDto;
import ru.itis.springboot.models.User;
import ru.itis.springboot.security.details.UserDetailsImpl;

import static ru.itis.springboot.dto.UserDto.from;

@Component
public class UserAuthenticationUtil {
    public UserDto getUserByUserDetails(UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        return from(user);
    }
}
