package ru.itis.web.services;

import ru.itis.web.dto.CarDto;
import ru.itis.web.forms.CarForm;
import ru.itis.web.models.Car;

import java.util.List;

public interface CarsService {
    List<CarDto> getCarsByUserId(Long userId);

    void addCarToUser(Long userId, CarForm form);
}
