package ru.itis.restapidemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.restapidemo.models.Community;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CommunityDto {
    private Long id;
    private String name;

    public static CommunityDto from(Community model) {
        return CommunityDto.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }

    public static List<CommunityDto> from(List<Community> models) {
        return models.stream()
                .map(CommunityDto::from)
                .collect(Collectors.toList());
    }
}
