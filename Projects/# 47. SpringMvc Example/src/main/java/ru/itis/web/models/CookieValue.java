package ru.itis.web.models;


import lombok.*;

@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CookieValue {
    private Long id;
    private User user;
    private String value;
}
