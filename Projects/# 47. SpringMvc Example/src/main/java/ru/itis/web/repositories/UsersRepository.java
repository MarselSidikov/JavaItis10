package ru.itis.web.repositories;


import ru.itis.web.models.User;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<User> {
    Optional<User> findOneByLogin(String login);
}
