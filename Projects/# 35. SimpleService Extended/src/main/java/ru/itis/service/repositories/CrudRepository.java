package ru.itis.service.repositories;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    Optional<T> findOneById(Long id);

    T save(T model);
    void update(T model);
    void delete(Long id);

    List<T> findAll();
}
