package com.example.institute.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Address {

    @Id
    @SequenceGenerator(name = "address_generator",allocationSize = 1, sequenceName = "address_generator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_generator")
    private Long id;

    private String street;
    private int number;
    private String city;
    private String state;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Student student;
}
