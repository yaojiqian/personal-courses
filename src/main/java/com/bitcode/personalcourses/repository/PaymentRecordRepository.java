package com.bitcode.personalcourses.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitcode.personalcourses.model.PaymentRecord;

public interface PaymentRecordRepository extends JpaRepository<PaymentRecord, Long> {
	List<PaymentRecord> findByInstitutionID(long inst_id);
}
