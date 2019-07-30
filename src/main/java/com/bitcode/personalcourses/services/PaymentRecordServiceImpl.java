package com.bitcode.personalcourses.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcode.personalcourses.exception.ResourceNotFoundException;
import com.bitcode.personalcourses.model.Institution;
import com.bitcode.personalcourses.model.PaymentRecord;
import com.bitcode.personalcourses.repository.InstitutionRepository;
import com.bitcode.personalcourses.repository.PaymentRecordRepository;

import java.util.Optional;

@Service
public class PaymentRecordServiceImpl implements PaymentRecordService {

	private PaymentRecordRepository paymentRecordRepo;
	private InstitutionRepository institutionRepo;
	
	@Autowired
	public void setInstitutionRepository(InstitutionRepository ir) {
		institutionRepo = ir;
	}
	
	@Autowired
	public void setPaymentRecordRepository(PaymentRecordRepository prs) {
		paymentRecordRepo = prs;
	}
	
	@Override
	public PaymentRecord addPaymentRecord(long ins_id, PaymentRecord pr) {

		Optional<Institution> ins = institutionRepo.findById(ins_id);
		
		if(ins.isPresent()) {
			pr.setInstitution(ins.get());
			paymentRecordRepo.save(pr);
		} else {
			String msg = String.format("The Institution %d is not found.", ins_id);
			throw new ResourceNotFoundException(msg);
		}
		
		return pr;
	}

	@Override
	public PaymentRecord updatePaymentRecord(long pr_id, PaymentRecord toUpdate) {

		PaymentRecord oldPr = getPaymentRecordById(pr_id);
		
		if(oldPr != null) {
			toUpdate.setID(oldPr.getID());
			paymentRecordRepo.save(toUpdate);
		} else {
			String msg = String.format("The payment record %d is not found.", pr_id);
			throw new ResourceNotFoundException(msg);
		}
		
		return toUpdate;
	}

	@Override
	public PaymentRecord deletePaymentRecord(long pr_id) {
		
		PaymentRecord oldPr = getPaymentRecordById(pr_id);
		
		if(oldPr != null) {
			
			paymentRecordRepo.deleteById(pr_id);
		} else {
			String msg = String.format("The payment record %d is not found.", pr_id);
			throw new ResourceNotFoundException(msg);
		}
		
		return oldPr;
	}

	@Override
	public List<PaymentRecord> getPaymentRecordByInstitutionID(long ins_id) {

		return paymentRecordRepo.findByInstitutionID(ins_id);
	}

	@Override
	public PaymentRecord getPaymentRecordById(long pr_id) {
		Optional<PaymentRecord> pr = paymentRecordRepo.findById(pr_id);
		
		if(!pr.isPresent()) {
			return null;
		}
		
		return pr.get();
	}

}
