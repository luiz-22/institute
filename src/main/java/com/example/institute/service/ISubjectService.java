package com.example.institute.service;

import com.example.institute.dto.SubjectDTO;
import com.example.institute.exception.BadRequestException;

import java.util.Set;

public interface ISubjectService {

    void createSubject(SubjectDTO subjectDTO);
    SubjectDTO getSubject(Long id) throws BadRequestException;
    void updateSubject(SubjectDTO subjectDTO);
    void deleteSubject(Long id);
    Set<SubjectDTO> getAll();
}
