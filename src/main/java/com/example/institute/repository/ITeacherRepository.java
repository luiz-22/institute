package com.example.institute.repository;

import com.example.institute.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT DISTINCT t FROM Teacher t JOIN FETCH t.listTeaches teaches JOIN FETCH teaches.subject")
    List<Teacher> findAllWithSubjects();
}
