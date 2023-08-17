package com.example.institute.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Course {

    @Id
    @SequenceGenerator(name = "course_generator", allocationSize = 1, sequenceName = "course_generator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_generator")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_student")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subject")
    private Subject subject;
}
