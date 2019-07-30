package com.bitcode.personalcourses.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitcode.personalcourses.model.CoursePlan;

public interface CoursePlanRepository extends JpaRepository<CoursePlan, Long> {
	List<CoursePlan> findByStudentID(Long stu_id);
	List<CoursePlan> findByTutorID(Long stu_id);
	List<CoursePlan> findByInstitutionID(Long ins_id);
}
