package com.bitcode.personalcourses.services;

import java.util.List;

import com.bitcode.personalcourses.model.CoursePlan;

public interface CoursePlanService {
	public CoursePlan addCoursePlan(Long stu_id, Long ins_id, Long tut_id, CoursePlan cp);
	public CoursePlan updateCoursePlan(Long cp_id, CoursePlan toUpdate);
	public CoursePlan deleteCoursePlan(Long cp_id);
	public CoursePlan getCoursePlanById(Long cp_id);
	public List<CoursePlan> getCoursePlanByStudent(Long stu_id);
	public List<CoursePlan> getAllCoursePlans();
}
