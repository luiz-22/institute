package com.example.institute.service.impl;

import com.example.institute.dto.SubjectDTO;
import com.example.institute.dto.TeacherDTO;
import com.example.institute.dto.TeacherWithSubjectsDTO;
import com.example.institute.entity.Teacher;
import com.example.institute.exception.BadRequestException;
import com.example.institute.repository.ITeacherRepository;
import com.example.institute.service.ITeacherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TeacherService implements ITeacherService {

    @Autowired
    private ITeacherRepository teacherRepository;

    @Autowired
    private ObjectMapper mapper;

/*    @Override
    public TeacherDTO createTeacher(TeacherDTO teacherDTO) {
        Teacher newTeacher = mapper.convertValue(teacherDTO, Teacher.class);
        teacherRepository.save(newTeacher);
        return teacherDTO;
    }*/

    @Override
    public TeacherDTO createTeacher(TeacherDTO teacherDTO) {
        Teacher newTeacher = mapper.convertValue(teacherDTO, Teacher.class);
        Teacher savedTeacher = teacherRepository.save(newTeacher);

        return mapper.convertValue(savedTeacher, TeacherDTO.class);
    }

    @Override
    public TeacherDTO getTeacher(Long id) throws BadRequestException {
        Optional<Teacher> found = teacherRepository.findById(id);
        if(found.isPresent())
            return mapper.convertValue(found, TeacherDTO.class);
        else
            throw new BadRequestException("Teacher Not Exist");
    }

    @Override
    public void updateTeacher(TeacherDTO teacherDTO) {
        Teacher updatedTeacher = mapper.convertValue(teacherDTO, Teacher.class);
        teacherRepository.save(updatedTeacher);
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public Set<TeacherDTO> getAll() {
        List<Teacher> allTeachers = teacherRepository.findAll();
        Set<TeacherDTO> allTeacherDTO = new HashSet<>();

        for (Teacher teacher : allTeachers) {
            allTeacherDTO.add(mapper.convertValue(teacher, TeacherDTO.class));
        }

        return allTeacherDTO;
    }


    @Override
    public List<TeacherWithSubjectsDTO> getAllTeachersWithSubjects() {
        List<Teacher> teachersWithSubjects = teacherRepository.findAllWithSubjects();

        return teachersWithSubjects.stream()
                .map(teacher -> {
                    TeacherWithSubjectsDTO teacherWithSubjectsDTO = new TeacherWithSubjectsDTO();
                    teacherWithSubjectsDTO.setId(teacher.getId());
                    teacherWithSubjectsDTO.setName(teacher.getName());
                    teacherWithSubjectsDTO.setLastname(teacher.getLastname());

                    List<SubjectDTO> subjectDTOs = teacher.getListTeaches().stream()
                            .map(teach -> {
                                SubjectDTO subjectDTO = new SubjectDTO();
                                subjectDTO.setId(teach.getSubject().getId());
                                subjectDTO.setName(teach.getSubject().getName());
                                return subjectDTO;
                            })
                            .collect(Collectors.toList());

                    teacherWithSubjectsDTO.setSubjects(subjectDTOs);
                    return teacherWithSubjectsDTO;
                })
                .collect(Collectors.toList());
    }
}