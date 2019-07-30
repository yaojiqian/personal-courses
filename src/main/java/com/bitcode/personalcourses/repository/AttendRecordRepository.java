package com.bitcode.personalcourses.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitcode.personalcourses.model.AttendRecord;

public interface AttendRecordRepository extends JpaRepository<AttendRecord, Long> {
	List<AttendRecord> findByStudentID(Long stu_id);
	List<AttendRecord> findByTutorID(Long tut_id);
}
