package ru.itis.restapidemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.restapidemo.dto.CarModelsResponseDto;
import ru.itis.restapidemo.services.CarsService;

@RestController
public class CarsController {

    @Autowired
    private CarsService carsService;

//    @GetMapping("/cars/models")
//    public ResponseEntity<CarModelsResponseDto> getCarModels(@RequestParam("limit") Long limit, @RequestParam("offset") Long offset) {
//        CarModelsResponseDto responseBody = CarModelsResponseDto.builder()
//                .data(carsService.getCarModels(limit, offset))
//                .build();
//        return ResponseEntity.ok(responseBody);
//    }

    @GetMapping("/cars/models")
    public ResponseEntity<CarModelsResponseDto> getCarModels(@RequestParam("page") Long page, @RequestParam("size") Long size) {
        CarModelsResponseDto responseBody = CarModelsResponseDto.builder()
                .data(carsService.getCarModels(page, size))
                .build();
        return ResponseEntity.ok(responseBody);
    }

}
