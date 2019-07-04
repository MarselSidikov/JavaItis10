package ru.itis;

import lombok.*;

import java.util.List;

@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "firstName", "lastName", "age"})
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String phone;
    private String email;
    private String login;
    private String password;
    private UserRole role;
}
