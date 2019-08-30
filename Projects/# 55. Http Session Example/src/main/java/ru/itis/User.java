package ru.itis;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {
    private String name;
    private String login;
}
