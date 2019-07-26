package ru.itis.web.repositories;

import ru.itis.web.models.CookieValue;

import java.util.Optional;

public interface CookieValuesRepository extends CrudRepository<CookieValue> {
    Optional<CookieValue> findOneByValue(String value);
}
