package com.bitcode.personalcourses.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcode.personalcourses.exception.ResourceNotFoundException;
import com.bitcode.personalcourses.model.Institution;
import com.bitcode.personalcourses.model.Tutor;
import com.bitcode.personalcourses.repository.InstitutionRepository;
import com.bitcode.personalcourses.repository.TutorRepository;

@Service
public class TutorServiceImpl implements TutorService {
	
	private TutorRepository tutorRepo;
	private InstitutionRepository institutionRepo;
	
	@Autowired
	public void setTutorRepository(TutorRepository tutorRepo) {
		this.tutorRepo = tutorRepo;
	}
	
	@Autowired
	public void setInstitutionRepository(InstitutionRepository instRepo) {
		this.institutionRepo = instRepo;
	}

	@Override
	public Tutor addTutor(long ins_id, Tutor tutor) throws ResourceNotFoundException {
		
		Optional<Institution> inst = institutionRepo.findById(ins_id);
		
		if(!inst.isPresent()) {
			throw new ResourceNotFoundException("the institution not found");
		}
		
		tutor.setInstitution(inst.get());
		
		tutorRepo.save(tutor);
		
		return tutor;
	}

	@Override
	public Tutor updateTutor(long tut_id, Tutor toUpdate) throws ResourceNotFoundException {

		Tutor tut = getTutorById(tut_id);
		
		if(tut == null) {
			String msg = String.format("The tutor %d is not found", tut_id);
			throw new ResourceNotFoundException(msg);
		}
		
		toUpdate.setID(tut_id);
		tutorRepo.save(toUpdate);
		
		return tut;
	}

	@Override
	public Tutor deleteTutor(long tut_id) throws ResourceNotFoundException {

		Tutor tut = getTutorById(tut_id);
		
		if(tut == null) {
			String msg = String.format("The tutor %d is not found", tut_id);
			throw new ResourceNotFoundException(msg);
		}
		
		tutorRepo.deleteById(tut_id);
		
		return tut;
	}

	@Override
	public List<Tutor> getTutorByInstitutionID(long ins_id) throws ResourceNotFoundException {
		
		List<Tutor> tuts = tutorRepo.findByInstitutionID(ins_id);
		
		return tuts;
	}

	@Override
	public Tutor getTutorById(long tut_id) {

		Optional<Tutor> tut = tutorRepo.findById(tut_id);
		
		if(!tut.isPresent()) {
			return null;
		}
		
		return tut.get();
	}

	@Override
	public Tutor addIndividualTutor(Tutor tutor) {

		Institution ins = new Institution();
		
		ins.setName(tutor.getName());
		ins.setPhone1(tutor.getContact());
		ins.setIs_individual('Y');
		Institution insNew = institutionRepo.save(ins);
		tutor.setInstitution(insNew);
		
		return tutorRepo.save(tutor);
	}

}
