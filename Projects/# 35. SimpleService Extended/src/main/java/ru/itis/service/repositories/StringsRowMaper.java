package ru.itis.service.repositories;

public interface StringsRowMaper<T> {
    T mapRow(String line);
}
