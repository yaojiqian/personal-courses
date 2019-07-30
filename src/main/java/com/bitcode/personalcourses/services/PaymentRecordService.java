package com.bitcode.personalcourses.services;

import java.util.List;

import com.bitcode.personalcourses.model.PaymentRecord;


public interface PaymentRecordService {

	PaymentRecord addPaymentRecord(long ins_id, PaymentRecord pr);
	PaymentRecord updatePaymentRecord(long pr_id, PaymentRecord toUpdate);
	PaymentRecord deletePaymentRecord(long pr_id);
	List<PaymentRecord> getPaymentRecordByInstitutionID(long ins_id);
	PaymentRecord getPaymentRecordById(long pr_id);
}
