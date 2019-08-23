package ru.itis.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.springboot.dto.CarDto;
import ru.itis.springboot.dto.CarModelDto;
import ru.itis.springboot.forms.CarForm;
import ru.itis.springboot.models.Car;
import ru.itis.springboot.models.User;
import ru.itis.springboot.repositories.CarModelsRepository;
import ru.itis.springboot.repositories.CarsRepository;

import java.util.List;

import static ru.itis.springboot.dto.CarDto.from;

@Service
public class CarsServiceImpl implements CarsService {

    @Autowired
    private CarsRepository carsRepository;

    @Autowired
    private CarModelsRepository carModelsRepository;

    @Transactional
    @Override
    public List<CarDto> getCarsByUserId(Long userId) {
        return from(carsRepository.findAllByOwner_Id(userId));
    }

    @Override
    @Transactional
    public void addCarToUser(Long userId, CarForm form) {
        Car car = Car.builder()
                .model(form.getModel())
                .number(form.getNumber())
                .owner(User.builder().id(userId).build())
                .build();
        carsRepository.save(car);
    }

    @Override
    public List<CarModelDto> getCarModelsBySearch(String query) {
        return CarModelDto.from(carModelsRepository.findAllByModelContainsIgnoreCase(query));
    }
}
