package com.example.institute.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Teach {

    @Id
    @SequenceGenerator(name = "teach_generator", allocationSize = 1, sequenceName = "teach_generator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teach_generator")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subject")
    private Subject subject;
}
