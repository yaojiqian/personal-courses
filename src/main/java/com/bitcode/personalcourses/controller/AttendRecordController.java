package com.bitcode.personalcourses.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

import com.bitcode.personalcourses.model.AttendRecord;
import com.bitcode.personalcourses.services.AttendRecordService;

@RestController
@RequestMapping("/api")
public class AttendRecordController {
	
	private AttendRecordService attendRecordService;
	private Logger logger = LoggerFactory.getLogger(AttendRecordController.class);
	
	@Autowired
	public void setAttendRecordService(AttendRecordService ars) {
		attendRecordService = ars;
	}
	
	@GetMapping("/AttendRecord")
	public List<AttendRecord> getAllAttendRecords() {
		logger.debug("/AttendRecord Get");
		return attendRecordService.getAllAttendRecords();
	}
	
	@GetMapping("/AttendRecord/Student/{stu_id}")
	public List<AttendRecord> getAttendRecordsByStudentId(@RequestParam("stu_id") Long stu_id) {
		logger.debug("/AttendRecord/Student/{} Get", stu_id);
		return attendRecordService.getAttendRecordByStudent(stu_id);
	}
	
	@GetMapping("/AttendRecord/Tutor/{tut_id}")
	public List<AttendRecord> getAttendRecordByTutorId(@RequestParam("tut_id") Long tut_id) {
		logger.debug("/AttendRecord/Tutor/{} Get", tut_id);
		return attendRecordService.getAttendRecordByTutor(tut_id);
	}
	
	@PostMapping("/AttendRecord/{stu_id}/{tut_id}")
	public AttendRecord addAttendRecord(@RequestParam("stu_id") Long stu_id, @RequestParam("tut_id") Long tut_id, @RequestBody AttendRecord att_r) {
		logger.debug("/AttendRecord/{}/{} Post, attendRecord: {}", stu_id, tut_id, att_r);
		return attendRecordService.addAttendRecord(stu_id, tut_id, att_r);
	}
	
	@PutMapping("/AttendRecord/{att_id}")
	public AttendRecord updateAttendRecord(@RequestParam("att_id") Long att_id, @RequestBody AttendRecord toUpdate) {
		logger.debug("/AttendRecord/{} Put, attendRecord: {}", att_id, toUpdate);
		return attendRecordService.updateAttendRecord(att_id, toUpdate);
	}
	
	@DeleteMapping("/AttendRecord/{att_id}")
	public AttendRecord deleteAttendRecord(@RequestParam("att_id") Long att_id) {
		logger.debug("/AttendRecord/{} Delete", att_id);
		return attendRecordService.deleteAttendRecord(att_id);
	}
}
