package com.example.institute.service.impl;

import com.example.institute.dto.AddressDTO;
import com.example.institute.dto.StudentDTO;
import com.example.institute.entity.Address;
import com.example.institute.entity.Student;
import com.example.institute.exception.BadRequestException;
import com.example.institute.repository.IStudentRepository;
import com.example.institute.service.IStudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public void createStudent(StudentDTO studentDTO) throws BadRequestException {
        System.out.println(studentDTO.getDni());
        if(studentRepository.getStudentByDNI(studentDTO.getDni()) != null) {
            throw new BadRequestException("Ya existe un paciente creado con ese dni");
        }
        Student newStudent = mapper.convertValue(studentDTO, Student.class);
        studentRepository.save(newStudent);
    }

    @Override
    public StudentDTO getStudent(Long id) throws BadRequestException {
        Optional<Student> found = studentRepository.findById(id);
        if(found.isPresent())
            return mapper.convertValue(found, StudentDTO.class);
        else
            throw new BadRequestException("Student Not Exist");
    }

    @Override
    public void updateStudent(StudentDTO studentDTO) {
        Student updatedStudent = mapper.convertValue(studentDTO, Student.class);
        studentRepository.save(updatedStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Set<StudentDTO> getAll() {
        List<Student> allStudents = studentRepository.findAll();
        Set<StudentDTO> allStudentDTO = new HashSet<>();

        for (Student student : allStudents) {
            allStudentDTO.add(mapper.convertValue(student, StudentDTO.class));
        }

        return allStudentDTO;
    }

    @Override
    public Set<StudentDTO> getStudentsWithLastnameLike(String lastname) {
        Set<Student> allStudents = studentRepository.getStudentByLastnameLike(lastname);
        Set<StudentDTO> allStudentsDTO = new HashSet<StudentDTO>();
        for(Student student: allStudents)
            allStudentsDTO.add(mapper.convertValue(student,StudentDTO.class));

        return allStudentsDTO;
    }
}
