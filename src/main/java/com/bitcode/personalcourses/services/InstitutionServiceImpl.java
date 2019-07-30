package com.bitcode.personalcourses.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcode.personalcourses.model.Institution;
import com.bitcode.personalcourses.repository.InstitutionRepository;

@Service
public class InstitutionServiceImpl implements InstitutionService {

	private InstitutionRepository instRepo;

	@Autowired
	public void setInstitutionRepository(InstitutionRepository instRepo) {
		this.instRepo = instRepo;
	}
	
	@Override
	public Institution createInstitution(Institution inst) {
		
		return instRepo.save(inst);
	}

	@Override
	public Institution deleteInstitution(long id) {
		
		Institution toDel = getInstitution(id);
		
		if(toDel != null) {
			instRepo.deleteById(id);
		}
		
		return toDel;
	}

	@Override
	public Institution updateInstitution(Institution newInst) {
		
		long id = newInst.getID();
		Institution oldInst = getInstitution(id);
		if(oldInst == null) {
			return null;
		} else {
			
			instRepo.save(newInst);
		}
		return oldInst;
	}

	@Override
	public List<Institution> getAllInstitutions() {
		
		List<Institution> listInst = instRepo.findAll();
		
		return listInst;
	}

	@Override
	public Institution getInstitution(long id) {

		Optional<Institution> inst = instRepo.findById(id);
		
		if(inst.isPresent()) {
			return inst.get();
		} else {
			return null;
		}
	}

}
