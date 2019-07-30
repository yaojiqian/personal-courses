package com.bitcode.personalcourses.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcode.personalcourses.model.CoursePlan;
import com.bitcode.personalcourses.services.AbsentRecordService;
import com.bitcode.personalcourses.services.CoursePlanService;

@RestController
@RequestMapping("/api")
public class CoursePlanController {

	private CoursePlanService coursePlanService;
	private Logger logger = LoggerFactory.getLogger(AbsentRecordService.class);
	
	@Autowired
	public void setCoursePlanService(CoursePlanService courseService) {
		
		coursePlanService = courseService;
	}
	
	@GetMapping("/CoursePlan")
	public List<CoursePlan> getCoursePlans(){
		logger.debug("/CoursePlan Get");
		return coursePlanService.getAllCoursePlans();
	}
	
	@GetMapping("/CoursePlan/{stu_id}")
	public List<CoursePlan> getCoursePlansByStudent(@RequestParam("stu_id") Long stu_id) {
		logger.debug("/CoursePlan/{} Get", stu_id);
		return coursePlanService.getCoursePlanByStudent(stu_id);
	}
	
	@PostMapping("/CoursePlan/{ins_id}/{tut_id}/{stu_id}")
	public CoursePlan addCoursePlan(@RequestParam("ins_id") Long ins_id, @RequestParam("tut_id") Long tut_id, @RequestParam("stu_id") Long stu_id, @RequestBody CoursePlan cp) {
		logger.debug("/CoursePlan/{}/{}/{}", ins_id, tut_id, stu_id);
		return coursePlanService.addCoursePlan(stu_id, ins_id, tut_id, cp);
	}
	
	@PutMapping("/CoursePlan/{cou_id}")
	public CoursePlan updateCoursePlan(@RequestParam("cou_id") Long cp_id, @RequestBody CoursePlan cp) {
		
		return coursePlanService.updateCoursePlan(cp_id, cp);
	}
	
	@DeleteMapping("/CoursePlan/{cou_id}")
	public CoursePlan deleteCoursePlan(@RequestParam("cou_id") Long cou_id) {
		
		return coursePlanService.deleteCoursePlan(cou_id);
	}
}
