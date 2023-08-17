package com.example.institute.controller;

import com.example.institute.dto.TeachDTO;
import com.example.institute.exception.BadRequestException;
import com.example.institute.service.ITeachService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/teaches")
public class TeachController {

    @Autowired
    ITeachService teachService;

    @PostMapping
    public ResponseEntity<?> createTeach(@Valid @RequestBody TeachDTO teachDTO) {
        teachService.createTeach(teachDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public TeachDTO getTeach(@PathVariable Long id) throws BadRequestException {
        return teachService.getTeach(id);
    }

    @PutMapping
    public ResponseEntity<?> updateTeach(@Valid @RequestBody TeachDTO teachDTO) {
        teachService.updateTeach(teachDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeach(@PathVariable Long id) {
        teachService.deleteTeach(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Set<TeachDTO> getAll() {
        return teachService.getAll();
    }
}
