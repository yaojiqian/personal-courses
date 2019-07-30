package com.bitcode.personalcourses.services;

import java.util.List;

import com.bitcode.personalcourses.model.Tutor;

public interface TutorService {
	
	Tutor addTutor(long ins_id, Tutor tutor);
	Tutor addIndividualTutor(Tutor tutor);
	Tutor updateTutor(long tut_id, Tutor toUpdate);
	Tutor deleteTutor(long tut_id);
	List<Tutor> getTutorByInstitutionID(long ins_id);
	Tutor getTutorById(long tut_id);
}
