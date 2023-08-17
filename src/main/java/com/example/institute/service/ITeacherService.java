package com.example.institute.service;

import com.example.institute.dto.TeacherDTO;
import com.example.institute.dto.TeacherWithSubjectsDTO;
import com.example.institute.exception.BadRequestException;

import java.util.List;
import java.util.Set;

public interface ITeacherService {

    TeacherDTO createTeacher(TeacherDTO teacherDTO);
    TeacherDTO getTeacher(Long id) throws BadRequestException;
    void updateTeacher(TeacherDTO teacherDTO);
    void deleteTeacher(Long id);
    Set<TeacherDTO> getAll();

    List<TeacherWithSubjectsDTO> getAllTeachersWithSubjects();
}
