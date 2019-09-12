package ru.itis.restapidemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.restapidemo.models.CarModel;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarModelDto {
    private Long id;
    private String model;

    public static CarModelDto from(CarModel model) {
        return CarModelDto.builder()
                .id(model.getId())
                .model(model.getModel())
                .build();
    }

    public static List<CarModelDto> from(List<CarModel> models) {
        return models.stream().map(CarModelDto::from).collect(Collectors.toList());
    }
}
