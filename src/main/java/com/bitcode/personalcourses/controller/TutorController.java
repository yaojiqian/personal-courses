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

import com.bitcode.personalcourses.model.Tutor;
import com.bitcode.personalcourses.services.TutorService;

@RestController
@RequestMapping("/api")
public class TutorController {

	private TutorService tutorService;
	private static final Logger logger = LoggerFactory.getLogger(TutorController.class);
	
	@Autowired
	public void setTutorService(TutorService tuts) {
		this.tutorService = tuts;
	}
	
	@PostMapping("/Institutions/{ins_id}/Tutors")
	public Tutor addTutorToInstitution(@PathVariable(value="ins_id") long ins_id, @Valid @RequestBody Tutor tut) {
		
		logger.debug("/Institutions/{}/Tutors Get", ins_id);
		return tutorService.addTutor(ins_id, tut);
	}
	
	@GetMapping("/Institutions/{ins_id}/Tutors")
	public List<Tutor> getTutorsByInstitutionId(@PathVariable(value="ins_id") long ins_id){
		
		return tutorService.getTutorByInstitutionID(ins_id);
	}
	
	@GetMapping("/Tutors/{tut_id}")
	public Tutor getTutorById(@PathVariable(value="tut_id") long tut_id) {
		
		return tutorService.getTutorById(tut_id);
	}
	
	@PostMapping("/Tutors")
	public Tutor addIndividualTutor(@Valid @RequestBody Tutor tut) {
		
		return tutorService.addIndividualTutor(tut);
	}
	
	@PutMapping("/Tutors/{tut_id}")
	public Tutor updateTutorById(@PathVariable(value="tut_id") long tut_id, Tutor tut) {
		
		return tutorService.updateTutor(tut_id, tut);
	}
	
	@DeleteMapping("/Tutors/{tut_id}")
	public Tutor deleteTutorById(@PathVariable(value="tut_id") long tut_id) {
		
		return tutorService.deleteTutor(tut_id);
	}
}
