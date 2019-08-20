package ru.itis.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.web.models.Car;

import java.util.List;

public interface CarsRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByOwner_Id(Long id);
}
