package com.example.institute.repository;

import com.example.institute.entity.Teach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeachRepository extends JpaRepository<Teach, Long> {
}
