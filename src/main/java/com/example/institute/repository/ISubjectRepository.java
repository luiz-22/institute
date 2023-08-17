package com.example.institute.repository;

import com.example.institute.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubjectRepository extends JpaRepository<Subject, Long> {
}
