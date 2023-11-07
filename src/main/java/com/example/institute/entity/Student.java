package com.example.institute.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(name = "student_generator", allocationSize = 1, sequenceName = "student_generator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_generator")
    private Long id;

    private String name;
    private String lastname;
    private int dni;
    private LocalDate birthdate;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address")
    private Address address;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Course> listCourses;
}
