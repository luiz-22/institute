package com.example.institute.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Teacher {

    @Id
    @SequenceGenerator(name = "teacher_generator", allocationSize = 1, sequenceName = "teacher_generator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_generator")
    private Long id;

    private String name;
    private String lastname;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Teach> listTeaches;
}
