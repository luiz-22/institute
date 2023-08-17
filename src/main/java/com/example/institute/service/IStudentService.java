package com.example.institute.service;

import com.example.institute.dto.StudentDTO;
import com.example.institute.exception.BadRequestException;

import java.util.Set;

public interface IStudentService {

    void createStudent(StudentDTO studentDTO) throws BadRequestException;
    StudentDTO getStudent(Long id) throws BadRequestException;
    void updateStudent(StudentDTO studentDTO);
    void deleteStudent(Long id);
    Set<StudentDTO> getAll();
    Set<StudentDTO> getStudentsWithLastnameLike(String lastname);
}
