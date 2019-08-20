package ru.itis.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.web.models.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String role;

    public boolean isAdmin() {
        return role.equals("ADMIN");
    }

    public static UserDto from(User model) {
        return UserDto.builder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .role(model.getRole().toString())
                .build();
    }

    public static List<UserDto> from(List<User> models) {
        return models.stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }
}
