package com.example.institute.controller;

import com.example.institute.dto.TeacherDTO;
import com.example.institute.dto.TeacherWithSubjectsDTO;
import com.example.institute.exception.BadRequestException;
import com.example.institute.service.ITeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    ITeacherService teacherService;

    /*@PostMapping
    public ResponseEntity<?> createTeacher(@Valid @RequestBody TeacherDTO teacherDTO) {
        teacherService.createTeacher(teacherDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }*/

    @PostMapping
    public ResponseEntity<TeacherDTO> createTeacher(@Valid @RequestBody TeacherDTO teacherDTO) {
        TeacherDTO createdTeacher = teacherService.createTeacher(teacherDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTeacher);
    }

    @GetMapping("/{id}")
    public TeacherDTO getTeacher(@PathVariable Long id) throws BadRequestException {
        return teacherService.getTeacher(id);
    }

    @PutMapping
    public ResponseEntity<?> updateTeacher(@Valid @RequestBody TeacherDTO teacherDTO) {
        teacherService.updateTeacher(teacherDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Set<TeacherDTO> getAll() {
        return teacherService.getAll();
    }

    @GetMapping("/with-subjects")
    public List<TeacherWithSubjectsDTO> getAllTeachersWithSubjects() {
        return teacherService.getAllTeachersWithSubjects();
    }
}
