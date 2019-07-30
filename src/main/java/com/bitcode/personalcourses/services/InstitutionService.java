package com.bitcode.personalcourses.services;

import java.util.List;

import com.bitcode.personalcourses.model.Institution;

public interface InstitutionService {
	
	public Institution createInstitution(Institution inst);
	public Institution deleteInstitution(long id);
	public Institution updateInstitution(Institution newInst);
	public List<Institution> getAllInstitutions();
	public Institution getInstitution(long id);
}
