package ru.itis.web.repositories;

import ru.itis.web.models.Car;

import java.util.List;

public interface CarsRepository extends CrudRepository<Car> {
    List<Car> findAllByUser_Id(Long userId);
}
