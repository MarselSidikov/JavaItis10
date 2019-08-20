package ru.itis.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.web.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
}
