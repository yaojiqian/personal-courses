package com.bitcode.personalcourses.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitcode.personalcourses.model.Tutor;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
	
	List<Tutor> findByInstitutionID(long inst_id); 
	
}
