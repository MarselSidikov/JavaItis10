package ru.itis.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springboot.models.CarModel;

import java.util.List;

public interface CarModelsRepository extends JpaRepository<CarModel, Long> {
    List<CarModel> findAllByModelContainsIgnoreCase(String query);
}
