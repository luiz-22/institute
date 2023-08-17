package com.example.institute.service.impl;

import com.example.institute.dto.CourseDTO;
import com.example.institute.entity.Course;
import com.example.institute.exception.BadRequestException;
import com.example.institute.repository.ICourseRepository;
import com.example.institute.service.ICourseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CourseService implements ICourseService {

    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public void createCourse(CourseDTO courseDTO) {
        Course newCourse = mapper.convertValue(courseDTO, Course.class);
        courseRepository.save(newCourse);
    }

    @Override
    public CourseDTO getCourse(Long id) throws BadRequestException {
        Optional<Course> found = courseRepository.findById(id);
        if(found.isPresent())
            return mapper.convertValue(found, CourseDTO.class);
        else
            throw new BadRequestException("Course Not Exist");
    }

    @Override
    public void updateCourse(CourseDTO courseDTO) {
        Course updatedCourse = mapper.convertValue(courseDTO, Course.class);
        courseRepository.save(updatedCourse);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Set<CourseDTO> getAll() {
        List<Course> allCourses = courseRepository.findAll();
        Set<CourseDTO> allCourseDTO = new HashSet<>();

        for (Course course : allCourses) {
            allCourseDTO.add(mapper.convertValue(course, CourseDTO.class));
        }

        return allCourseDTO;
    }
}
