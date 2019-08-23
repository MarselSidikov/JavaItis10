package ru.itis.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springboot.models.Car;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDto {
    private Long id;
    private String model;
    private String number;

    public static CarDto from(Car model) {
        return CarDto.builder()
                .id(model.getId())
                .number(model.getNumber())
                .model(model.getModel())
                .build();
    }

    public static List<CarDto> from(List<Car> models) {
        return models.stream()
                .map(CarDto::from)
                .collect(Collectors.toList());
    }
}
