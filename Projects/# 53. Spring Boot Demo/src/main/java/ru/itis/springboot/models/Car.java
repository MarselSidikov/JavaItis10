package ru.itis.springboot.models;

import lombok.*;

import javax.persistence.*;

@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String number;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
}
