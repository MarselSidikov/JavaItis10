package ru.itis.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.web.dto.CarDto;
import ru.itis.web.forms.CarForm;
import ru.itis.web.models.Car;
import ru.itis.web.models.User;
import ru.itis.web.repositories.CarsRepository;

import java.util.List;

import static ru.itis.web.dto.CarDto.from;

@Service
public class CarsServiceImpl implements CarsService {

    @Autowired
    private CarsRepository carsRepository;

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
}
