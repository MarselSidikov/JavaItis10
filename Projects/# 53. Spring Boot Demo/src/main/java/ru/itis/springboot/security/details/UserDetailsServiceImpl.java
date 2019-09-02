package ru.itis.springboot.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.springboot.models.User;
import ru.itis.springboot.repositories.UsersRepository;

import java.util.Optional;

// сервис, который позволяет получить пользтвателя в виде UserDetails
// по его имени пользователя
@Service(value = "customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        // находим пользователя по логину
        Optional<User> userCandidate = usersRepository.findByLogin(login);
        // если пользователь есть
        if (userCandidate.isPresent()) {
            // вытаскиваем его из Optional
            User user = userCandidate.get();
            // создаем объект UserDetailsImpl, упаковываем внутрь него
            // нашего пользователя
            // и возвращаем в качестве результата
            return new UserDetailsImpl(user);
        }
        // если пользователь не найден, генерирурем исключение
        throw new UsernameNotFoundException("User with login " + login + " not found");
    }
}
