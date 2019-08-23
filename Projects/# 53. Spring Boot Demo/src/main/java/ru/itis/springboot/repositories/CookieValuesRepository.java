package ru.itis.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springboot.models.CookieValue;

import java.util.Optional;

public interface CookieValuesRepository extends JpaRepository<CookieValue, Long> {
    Optional<CookieValue> findByValue(String value);
}
