package ru.itis.restapidemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.restapidemo.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {
}
