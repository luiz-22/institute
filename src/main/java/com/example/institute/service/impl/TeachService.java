package com.example.institute.service.impl;

import com.example.institute.dto.AddressDTO;
import com.example.institute.dto.TeachDTO;
import com.example.institute.entity.Address;
import com.example.institute.entity.Subject;
import com.example.institute.entity.Teach;
import com.example.institute.entity.Teacher;
import com.example.institute.exception.BadRequestException;
import com.example.institute.repository.ISubjectRepository;
import com.example.institute.repository.ITeachRepository;
import com.example.institute.repository.ITeacherRepository;
import com.example.institute.service.ITeachService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TeachService implements ITeachService {

    @Autowired
    private ITeachRepository teachRepository;

    @Autowired
    private ITeacherRepository teacherRepository;

    @Autowired
    private ISubjectRepository subjectRepository;

    @Autowired
    private ObjectMapper mapper;

/*    @Override
    public void createTeach(TeachDTO teachDTO) {
        Teach newTeach = mapper.convertValue(teachDTO, Teach.class);
        teachRepository.save(newTeach);
    }*/

    @Override
    public void createTeach(TeachDTO teachDTO) {
        Teach newTeach = mapper.convertValue(teachDTO, Teach.class);

        // Obtén el profesor y la materia a partir de los IDs
        Teacher teacher = teacherRepository.getById(teachDTO.getTeacherId());
        Subject subject = subjectRepository.getById(teachDTO.getSubjectId());

        // Asigna el profesor y la materia al nuevo Teach
        newTeach.setTeacher(teacher);
        newTeach.setSubject(subject);

        teachRepository.save(newTeach);
    }


    @Override
    public TeachDTO getTeach(Long id) throws BadRequestException {
        Optional<Teach> found = teachRepository.findById(id);
        if(found.isPresent())
            return mapper.convertValue(found, TeachDTO.class);
        else
            throw new BadRequestException("Teach Not Exist");
    }

    @Override
    public void updateTeach(TeachDTO teachDTO) {
        Teach updatedTeach = mapper.convertValue(teachDTO, Teach.class);
        teachRepository.save(updatedTeach);
    }

    @Override
    public void deleteTeach(Long id) {
        teachRepository.deleteById(id);
    }

    @Override
    public Set<TeachDTO> getAll() {
        List<Teach> allTeaches = teachRepository.findAll();
        Set<TeachDTO> allTeachDTO = new HashSet<>();

        for (Teach teach : allTeaches) {
            allTeachDTO.add(mapper.convertValue(teach, TeachDTO.class));
        }

        return allTeachDTO;
    }
}
