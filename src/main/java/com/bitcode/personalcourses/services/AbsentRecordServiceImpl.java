package com.bitcode.personalcourses.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcode.personalcourses.exception.ResourceNotFoundException;
import com.bitcode.personalcourses.model.AbsentRecord;
import com.bitcode.personalcourses.model.CoursePlan;
import com.bitcode.personalcourses.repository.AbsentRecordRepository;
import com.bitcode.personalcourses.repository.CoursePlanRepository;

@Service
public class AbsentRecordServiceImpl implements AbsentRecordService {
	
	private AbsentRecordRepository absentRecordRepo;
	private CoursePlanRepository coursePlanRepo;
	
	@Autowired
	public void setAbsentRecordRepository(AbsentRecordRepository arr) {
		absentRecordRepo = arr;
	}
	
	@Autowired
	public void setCoursePlanRepository(CoursePlanRepository cpr) {
		coursePlanRepo = cpr;
	}

	@Override
	public AbsentRecord addAbsentRecord(Long cou_id, AbsentRecord abs_r) {

		Optional<CoursePlan> coursePlan = coursePlanRepo.findById(cou_id);
		
		if(!coursePlan.isPresent()) {
			throw new ResourceNotFoundException("Can't find the course plan");
		}
		
		abs_r.setCoursePlan(coursePlan.get());
		
		return absentRecordRepo.save(abs_r);
	}

	@Override
	public AbsentRecord updateAbsentRecord(Long abs_id, AbsentRecord toUpdate) {

		AbsentRecord oldRecord = getAbsentRecordById(abs_id);
		
		if(oldRecord == null) {
			throw new ResourceNotFoundException("the absent record is not found.");
		}
		
		toUpdate.setID(oldRecord.getID());
		
		absentRecordRepo.save(toUpdate);
		
		return oldRecord;
	}

	@Override
	public AbsentRecord deleteAbsentRecord(Long abs_id) {

		AbsentRecord oldRecord = getAbsentRecordById(abs_id);
		
		if(oldRecord == null) {
			throw new ResourceNotFoundException("the absent record is not found.");
		}
		
		absentRecordRepo.deleteById(abs_id);
		
		return oldRecord;
	}

	@Override
	public AbsentRecord getAbsentRecordById(Long abs_id) {

		Optional<AbsentRecord> absentRecord = absentRecordRepo.findById(abs_id);
		
		if(absentRecord.isPresent()) {
			return absentRecord.get();
		} else
			return null;
	}

	@Override
	public List<AbsentRecord> getAbsentRecordByCoursePlan(Long cou_id) {
		
		return absentRecordRepo.findByCoursePlanID(cou_id);
		//return null;
	}
	
	@Override
	public List<AbsentRecord> getAllAbsentRecords() {
		
		return absentRecordRepo.findAll();
	}
}
