package ru.itis.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.web.dto.CarForm;
import ru.itis.web.models.Car;
import ru.itis.web.models.User;
import ru.itis.web.repositories.CarsRepository;

import java.util.List;

@Component
public class CarsServiceImpl implements CarsService {

    @Autowired
    private CarsRepository carsRepository;

    @Override
    public List<Car> getCarsByUserId(Long userId) {
        return carsRepository.findAllByUser_Id(userId);
    }

    @Override
    public void addCarToUser(Long userId, CarForm form) {
        Car car = Car.builder()
                .model(form.getModel())
                .number(form.getNumber())
                .owner(User.builder().id(userId).build())
                .build();
        carsRepository.save(car);
    }
}
