package com.bitcode.personalcourses.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitcode.personalcourses.model.AbsentRecord;

public interface AbsentRecordRepository extends JpaRepository<AbsentRecord, Long> {
	List<AbsentRecord> findByCoursePlanID(Long cou_id);
}
