package ru.itis.service.repositories;

import ru.itis.service.models.Car;
import ru.itis.service.models.User;

import java.util.List;
import java.util.Optional;

public interface CarsRepository extends CrudRepository<Car> {
    List<Car> findAllByOwner(User owner);

}
