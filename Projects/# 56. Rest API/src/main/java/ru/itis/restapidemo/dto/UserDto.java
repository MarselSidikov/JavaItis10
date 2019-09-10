package ru.itis.restapidemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.restapidemo.models.User;

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
    private String email;

    @JsonIgnore
    private User user;

    public static UserDto from(User model) {
        UserDto result = UserDto.builder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .build();
        result.user = model;
        return result;
    }

    public static List<UserDto> from(List<User> models) {
        return models.stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }

    public UserDto withEmail() {
        if (user != null) {
            this.email = user.getEmail();
        }
        return this;
    }
}
