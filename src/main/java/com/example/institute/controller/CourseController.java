package com.example.institute.controller;

import com.example.institute.dto.CourseDTO;
import com.example.institute.exception.BadRequestException;
import com.example.institute.service.ICourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    ICourseService courseService;

    @PostMapping
    public ResponseEntity<?> createCourse(@Valid @RequestBody CourseDTO courseDTO) {
        courseService.createCourse(courseDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public CourseDTO getCourse(@PathVariable Long id) throws BadRequestException {
        return courseService.getCourse(id);
    }

    @PutMapping
    public ResponseEntity<?> updateCourse(@Valid @RequestBody CourseDTO courseDTO) {
        courseService.updateCourse(courseDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Set<CourseDTO> getAll() {
        return courseService.getAll();
    }
}
