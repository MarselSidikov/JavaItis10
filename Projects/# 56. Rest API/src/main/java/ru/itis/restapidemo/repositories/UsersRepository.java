package ru.itis.restapidemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.restapidemo.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
