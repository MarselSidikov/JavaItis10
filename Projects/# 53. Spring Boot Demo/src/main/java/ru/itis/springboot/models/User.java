package ru.itis.springboot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import ru.itis.springboot.models.enums.UserRole;
import ru.itis.springboot.models.enums.UserState;

import javax.persistence.*;
import java.util.List;

@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "service_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 20)
    private String firstName;
    @Column(name = "last_name", length = 20)
    private String lastName;

    private Integer age;
    private String phone;
    private String email;
    private String login;
    private String hashPassword;

    @Enumerated(value = EnumType.STRING)
    private UserRole role;

    @Enumerated(value = EnumType.STRING)
    private UserState state;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Car> cars;

    private String confirmUUID;
}
