package ru.itis.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springboot.models.CarModel;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarModelDto {
    private String model;

    public static CarModelDto from(CarModel model) {
        return new CarModelDto(model.getModel());
    }

    public static List<CarModelDto> from(List<CarModel> models) {
        return models
                .stream()
                .map(CarModelDto::from)
                .collect(Collectors.toList());
    }
}
