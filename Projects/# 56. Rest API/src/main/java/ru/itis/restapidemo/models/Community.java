package ru.itis.restapidemo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "user_community",
    joinColumns = @JoinColumn(name = "community_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id"))
    private List<User> members;
}
