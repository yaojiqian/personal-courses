package com.bitcode.personalcourses.services;

import java.util.List;

import com.bitcode.personalcourses.model.AttendRecord;

public interface AttendRecordService {
	public AttendRecord addAttendRecord(Long stu_id, Long tut_id, AttendRecord att_r);
	public AttendRecord updateAttendRecord(Long att_id, AttendRecord toUpdate);
	public AttendRecord deleteAttendRecord(Long att_id);
	public AttendRecord getAttendRecordById(Long att_id);
	public List<AttendRecord> getAttendRecordByStudent(Long stu_id);
	public List<AttendRecord> getAttendRecordByTutor(Long tut_id);
	public List<AttendRecord> getAllAttendRecords();
}
