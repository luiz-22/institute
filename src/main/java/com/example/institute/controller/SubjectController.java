package com.example.institute.controller;

import com.example.institute.dto.SubjectDTO;
import com.example.institute.exception.BadRequestException;
import com.example.institute.service.ISubjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    ISubjectService subjectService;

    @PostMapping
    public ResponseEntity<?> createSubject(@Valid @RequestBody SubjectDTO subjectDTO) {
        subjectService.createSubject(subjectDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public SubjectDTO getSubject(@PathVariable Long id) throws BadRequestException {
        return subjectService.getSubject(id);
    }

    @PutMapping
    public ResponseEntity<?> updateSubject(@Valid @RequestBody SubjectDTO subjectDTO) {
        subjectService.updateSubject(subjectDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubject(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Set<SubjectDTO> getAll() {
        return subjectService.getAll();
    }
}