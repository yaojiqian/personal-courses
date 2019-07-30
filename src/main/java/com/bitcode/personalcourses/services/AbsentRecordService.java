package com.bitcode.personalcourses.services;

import java.util.List;

import com.bitcode.personalcourses.model.AbsentRecord;

public interface AbsentRecordService {
	public AbsentRecord addAbsentRecord(Long cou_id, AbsentRecord abs_r);
	public AbsentRecord updateAbsentRecord(Long abs_id, AbsentRecord toUpdate);
	public AbsentRecord deleteAbsentRecord(Long abs_id);
	public AbsentRecord getAbsentRecordById(Long abs_id);
	public List<AbsentRecord> getAbsentRecordByCoursePlan(Long cou_id);
	public List<AbsentRecord> getAllAbsentRecords();
}
