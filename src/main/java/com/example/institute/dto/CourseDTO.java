package com.example.institute.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private Long id;
    private StudentDTO student;  // Utiliza el DTO de Student en lugar de la entidad
    private SubjectDTO subject;  // Utiliza el DTO de Subject en lugar de la entidad
}
