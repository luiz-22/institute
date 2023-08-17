package com.example.institute.repository;

import com.example.institute.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

    @Query("from Student s where s.dni = :dni")
    Student getStudentByDNI(@Param("dni") int dni);

    @Query("from Student s where s.lastname like %:lastname%")
    Set<Student> getStudentByLastnameLike(@Param("lastname") String lastname);
}
