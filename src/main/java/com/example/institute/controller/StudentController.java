package com.example.institute.controller;

import com.example.institute.dto.StudentDTO;
import com.example.institute.exception.BadRequestException;
import com.example.institute.service.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @PostMapping
    public ResponseEntity<?> createStudent(@Valid @RequestBody StudentDTO studentDTO) throws BadRequestException {
        studentService.createStudent(studentDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public StudentDTO getStudent(@PathVariable Long id) throws BadRequestException {
        return studentService.getStudent(id);
    }

    @PutMapping
    public ResponseEntity<?> updateStudent(@Valid @RequestBody StudentDTO studentDTO) {
        studentService.updateStudent(studentDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Set<StudentDTO> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/getLastnameLike")
    public Set<StudentDTO> listStudentsWithLastnameLike(@RequestParam String lastname) {
        return studentService.getStudentsWithLastnameLike(lastname);
    }
}
