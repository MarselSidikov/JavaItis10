package ru.itis.web.services;

import ru.itis.web.dto.CarForm;
import ru.itis.web.models.Car;

import java.util.List;

public interface CarsService {
    List<Car> getCarsByUserId(Long userId);

    void addCarToUser(Long userId, CarForm form);
}
