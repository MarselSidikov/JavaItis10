package ru.itis.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springboot.models.Car;

import java.util.List;

public interface CarsRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByOwner_Id(Long id);
}
