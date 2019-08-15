package ru.itis.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.web.dto.CarForm;
import ru.itis.web.models.Car;
import ru.itis.web.models.User;
import ru.itis.web.repositories.CarsRepository;

import java.util.List;

@Service
public class CarsServiceImpl implements CarsService {

    @Autowired
    @Qualifier(value = "cars.repository.jpa.impl")
    private CarsRepository carsRepository;

    @Transactional
    @Override
    public List<Car> getCarsByUserId(Long userId) {
        return carsRepository.findAllByUser_Id(userId);
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
}
