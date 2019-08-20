package ru.itis.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springboot.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {
}
