package com.example.institute.service.impl;

import com.example.institute.dto.AddressDTO;
import com.example.institute.dto.SubjectDTO;
import com.example.institute.entity.Address;
import com.example.institute.entity.Subject;
import com.example.institute.exception.BadRequestException;
import com.example.institute.repository.ISubjectRepository;
import com.example.institute.service.ISubjectService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SubjectService implements ISubjectService {

    @Autowired
    private ISubjectRepository subjectRepository;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public void createSubject(SubjectDTO subjectDTO) {
        Subject newSubject = mapper.convertValue(subjectDTO, Subject.class);
        subjectRepository.save(newSubject);
    }

    @Override
    public SubjectDTO getSubject(Long id) throws BadRequestException {
        Optional<Subject> found = subjectRepository.findById(id);
        if(found.isPresent())
            return mapper.convertValue(found, SubjectDTO.class);
        else
            throw new BadRequestException("Subject Not Exist");
    }

    @Override
    public void updateSubject(SubjectDTO subjectDTO) {
        Subject updatedSubject = mapper.convertValue(subjectDTO, Subject.class);
        subjectRepository.save(updatedSubject);
    }

    @Override
    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public Set<SubjectDTO> getAll() {
        List<Subject> allSubjects = subjectRepository.findAll();
        Set<SubjectDTO> allSubjectDTO = new HashSet<>();

        for (Subject subject : allSubjects) {
            allSubjectDTO.add(mapper.convertValue(subject, SubjectDTO.class));
        }

        return allSubjectDTO;
    }
}
