package ru.itis.springboot.services;

import ru.itis.springboot.dto.CarDto;
import ru.itis.springboot.dto.CarModelDto;
import ru.itis.springboot.forms.CarForm;

import java.util.List;

public interface CarsService {
    List<CarDto> getCarsByUserId(Long userId);

    void addCarToUser(Long userId, CarForm form);

    List<CarModelDto> getCarModelsBySearch(String query);
}
