package com.example.institute.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private Long id;
    private String street;
    private int number;
    private String city;
    private String state;
}
