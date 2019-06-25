package ru.itis.service.models;

import lombok.*;

@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private Long id;
    private String model;
    private User owner;
}
