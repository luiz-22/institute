package com.example.institute.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeachDTO {
    private Long id;
    //private TeacherDTO teacher;  // Utiliza el DTO de Teacher en lugar de la entidad
    //private SubjectDTO subject;  // Utiliza el DTO de Subject en lugar de la entidad
    private Long teacherId;  // Agrega este campo
    private Long subjectId;  // Agrega este campo
}
