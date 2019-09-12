package ru.itis.restapidemo.services;

import ru.itis.restapidemo.dto.CarModelDto;

import java.util.List;

public interface CarsService {
//    List<CarModelDto> getCarModels(Long limit, Long offset);
    List<CarModelDto> getCarModels(Long page, Long size);
}
