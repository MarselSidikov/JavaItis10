package ru.itis.service.repositories;

public interface RowMapper<T> {
    T mapRow(String line);
}
