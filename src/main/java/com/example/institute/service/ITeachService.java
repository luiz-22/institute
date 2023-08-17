package com.example.institute.service;

import com.example.institute.dto.TeachDTO;
import com.example.institute.exception.BadRequestException;

import java.util.Set;

public interface ITeachService {

    void createTeach(TeachDTO teachDTO);
    TeachDTO getTeach(Long id) throws BadRequestException;
    void updateTeach(TeachDTO teachDTO);
    void deleteTeach(Long id);
    Set<TeachDTO> getAll();
}
