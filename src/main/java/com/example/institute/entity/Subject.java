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
public class Subject {

    @Id
    @SequenceGenerator(name = "subject_generator", allocationSize = 1, sequenceName = "subject_generator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_generator")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Teach> listTeaches;

    public Subject(String name) {
        this.name = name;
    }
}
