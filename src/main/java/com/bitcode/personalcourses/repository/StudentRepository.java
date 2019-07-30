package com.bitcode.personalcourses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitcode.personalcourses.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
