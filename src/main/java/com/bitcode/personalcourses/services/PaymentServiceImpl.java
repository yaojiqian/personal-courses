package com.bitcode.personalcourses.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcode.personalcourses.exception.ResourceNotFoundException;
import com.bitcode.personalcourses.model.Institution;
import com.bitcode.personalcourses.model.PaymentRecord;
import com.bitcode.personalcourses.repository.InstitutionRepository;
import com.bitcode.personalcourses.repository.PaymentRecordRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	private PaymentRecordRepository paymentRecordRepository;
	private InstitutionRepository institutionRepository;
	
	@Autowired
	public void setPaymentRecordRepository(PaymentRecordRepository prr) {
		paymentRecordRepository = prr;
	}
	
	@Autowired
	public void setInstitutionRepository(InstitutionRepository ir) {
		institutionRepository = ir;
	}
	
	@Override
	public void pay(Long ins_id, double amount, double realAmount) {
		
		Optional<Institution> institution = institutionRepository.findById(ins_id);
		
		if(!institution.isPresent()) {
			throw new ResourceNotFoundException("the institution is not found");
		}
		
		PaymentRecord paymentRecord = new PaymentRecord();
		
		Institution inst = institution.get();
		double currentBalance = inst.getBalance();
		double curAccBal = inst.getAccount_balance();
		double totalAmount = inst.getTotal_amount();
		
		double newCurBalance = currentBalance + realAmount;
		double newCurAccBal = curAccBal + amount;
		double newTotalAmount = totalAmount + realAmount; 
		Date thePayTime = new Date();
		
		paymentRecord.setAccount_balance(newCurAccBal);
		paymentRecord.setPromotional_amount(amount);
		paymentRecord.setAmount(realAmount);
		paymentRecord.setBalance(newCurBalance);
		paymentRecord.setPay_time(thePayTime);
		paymentRecord.setInstitution(inst);
		
		inst.setAccount_balance(newCurAccBal);
		inst.setBalance(newCurBalance);
		inst.setTotal_amount(newTotalAmount);
		
		institutionRepository.save(inst);
		paymentRecordRepository.save(paymentRecord);		
	}

}
