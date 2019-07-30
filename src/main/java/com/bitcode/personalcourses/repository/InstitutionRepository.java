package com.bitcode.personalcourses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitcode.personalcourses.model.Institution;


public interface InstitutionRepository extends JpaRepository<Institution, Long>{

}
