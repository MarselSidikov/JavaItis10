package ru.itis.web.models;

import lombok.*;

@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
