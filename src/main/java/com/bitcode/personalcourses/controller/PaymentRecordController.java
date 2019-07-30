package com.bitcode.personalcourses.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcode.personalcourses.model.PaymentRecord;
import com.bitcode.personalcourses.services.PaymentRecordService;

@RestController
@RequestMapping("/api")
public class PaymentRecordController {

	private PaymentRecordService paymentRecordService;
	private static final Logger logger = LoggerFactory.getLogger(PaymentRecordController.class);
	
	@Autowired
	public void setPaymentRecordService(PaymentRecordService prs) {
		paymentRecordService = prs;
	}
	
	@PostMapping("/Institutions/{ins_id}/PaymentRecords")
	public PaymentRecord addPaymentRecord(@PathVariable(name="ins_id") long ins_id, @Valid @RequestBody PaymentRecord pr) {
		
		
		
		return paymentRecordService.addPaymentRecord(ins_id, pr);
	}
	
	@DeleteMapping("/PaymentRecords/{pay_id}")
	public PaymentRecord deletePaymentRecord(@PathVariable(name="pay_id") long pay_id) {
		
		return paymentRecordService.deletePaymentRecord(pay_id);
	}
	
	@PutMapping("/PaymentRecords/{pay_id}")
	public PaymentRecord updatePaymentRecord(@PathVariable(name="pay_id") long pay_id, @Valid @RequestBody PaymentRecord pr) {
		
		return paymentRecordService.updatePaymentRecord(pay_id, pr);
	}
	
	@GetMapping("/Institutions/{ins_d}/PaymentRecords")
	public List<PaymentRecord> getPaymentRecordsByInstitutionID(@PathVariable(name="ins_id") long ins_id){
		logger.debug("/Institutions/{}/PaymentRecords", ins_id);
		return paymentRecordService.getPaymentRecordByInstitutionID(ins_id);
	}
	
	@GetMapping("/PaymentRecords/{pay_id}")
	public PaymentRecord getPaymentRecordById(@PathVariable(name="pay_id") long pay_id) {
		
		return paymentRecordService.getPaymentRecordById(pay_id);
	}
}
