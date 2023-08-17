package com.example.institute.service;

import com.example.institute.dto.CourseDTO;
import com.example.institute.exception.BadRequestException;

import java.util.Set;

public interface ICourseService {

    void createCourse(CourseDTO courseDTO);
    CourseDTO getCourse(Long id) throws BadRequestException;
    void updateCourse(CourseDTO courseDTO);
    void deleteCourse(Long id);
    Set<CourseDTO> getAll();
}
