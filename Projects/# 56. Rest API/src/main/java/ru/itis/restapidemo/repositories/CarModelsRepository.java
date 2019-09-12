package ru.itis.restapidemo.repositories;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.restapidemo.models.CarModel;

import java.util.List;

public interface CarModelsRepository extends JpaRepository<CarModel, Long> {
//    @Query(nativeQuery = true, value = "select * from car_model limit :limit_ offset :offset_")
//    List<CarModel> getCarModels(@Param("limit_") Long limit,@Param("offset_") Long offset);


}
