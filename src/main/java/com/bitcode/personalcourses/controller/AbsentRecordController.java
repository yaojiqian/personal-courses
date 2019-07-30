package com.bitcode.personalcourses.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcode.personalcourses.model.AbsentRecord;
import com.bitcode.personalcourses.services.AbsentRecordService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AbsentRecordController {
	
	private AbsentRecordService absentRecordService;
	private Logger logger = LoggerFactory.getLogger(AbsentRecordController.class);
	
	@Autowired
	public void setAbsentRecordService(AbsentRecordService abs) {
		absentRecordService = abs;
	}
	
	@GetMapping("/AbsentRecord")
	public List<AbsentRecord> getAllAbsentRecords() {
		logger.debug("/AbsentRecord Get");
		return absentRecordService.getAllAbsentRecords();
	}
	
	@GetMapping("/AbsentRecord/Student/{cou_id}")
	public List<AbsentRecord> getAbsentRecordsByStudentId(@RequestParam("cou_id") Long cou_id) {
		logger.debug("/AbsentRecord/Student/{} Get", cou_id);
		return absentRecordService.getAbsentRecordByCoursePlan(cou_id);
	}
	
	@PostMapping("/AbsentRecord/{cou_id}")
	public AbsentRecord addAbsentRecord(@RequestParam("cou_id") Long cou_id, @RequestBody AbsentRecord abs_r) {
		logger.debug("/AbsentRecord/{} Post, absentRecord:{}", cou_id, abs_r);
		return absentRecordService.addAbsentRecord(cou_id, abs_r);
	}
	
	@PutMapping("/AbsentRecord/{abs_id}")
	public AbsentRecord updateAbsentRecord(@RequestParam("abs_id") Long abs_id, @RequestBody AbsentRecord toUpdate) {
		
		return absentRecordService.updateAbsentRecord(abs_id, toUpdate);
	}
	
	@DeleteMapping("/AbsentRecord/{abs_id}")
	public AbsentRecord deleteAbsentRecord(@RequestParam("abs_id") Long abs_id) {
		
		return absentRecordService.deleteAbsentRecord(abs_id);
	}
}
