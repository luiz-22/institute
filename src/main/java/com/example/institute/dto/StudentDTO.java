package com.example.institute.dto;

import com.example.institute.entity.Address;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String name;
    private String lastname;
    private int dni;
    private LocalDate birthdate;
    private Address address;
}
