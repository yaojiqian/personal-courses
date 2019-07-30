package com.bitcode.personalcourses.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcode.personalcourses.exception.ResourceNotFoundException;
import com.bitcode.personalcourses.model.CoursePlan;
import com.bitcode.personalcourses.model.Institution;
import com.bitcode.personalcourses.model.Student;
import com.bitcode.personalcourses.model.Tutor;
import com.bitcode.personalcourses.repository.CoursePlanRepository;
import com.bitcode.personalcourses.repository.InstitutionRepository;
import com.bitcode.personalcourses.repository.StudentRepository;
import com.bitcode.personalcourses.repository.TutorRepository;

@Service
public class CoursePlanServiceImpl implements CoursePlanService {

	private CoursePlanRepository coursePlanRepo;
	private InstitutionRepository institutionRepo;
	private StudentRepository studentRepo;
	private TutorRepository tutorRepo;
	
	@Autowired
	public void setCoursePlanRepository(CoursePlanRepository cpr) {
		coursePlanRepo = cpr;
	}
	
	@Autowired
	public void setInstitutionRepo(InstitutionRepository ir) {
		institutionRepo = ir;
	}
	
	@Autowired
	public void setStudentRepository(StudentRepository sr) {
		studentRepo = sr;
	}
	
	@Autowired
	public void setTutorRepository(TutorRepository tr) {
		tutorRepo = tr;
	}
	
	@Override
	public CoursePlan addCoursePlan(Long stu_id, Long ins_id, Long tut_id, CoursePlan cp) {

		Optional<Student> student = studentRepo.findById(stu_id);
		
		if(!student.isPresent()) {
			throw new ResourceNotFoundException("the student not found");
		}
		
		Optional<Institution> institution = institutionRepo.findById(ins_id);
		
		if(!institution.isPresent()) {
			throw new ResourceNotFoundException("the institution not found");
		}
		
		Optional<Tutor> tutor = tutorRepo.findById(tut_id);
		
		if(!tutor.isPresent()) {
			throw new ResourceNotFoundException("the tutor not found");
		}
		
		cp.setStudent(student.get());
		cp.setInstitution(institution.get());
		cp.setTutor(tutor.get());
		
		CoursePlan retVal = coursePlanRepo.save(cp);

		return retVal;
	}

	@Override
	public CoursePlan updateCoursePlan(Long cp_id, CoursePlan toUpdate) {
		CoursePlan oldCp = getCoursePlanById(cp_id);
		
		if(oldCp != null) {
			toUpdate.setID(oldCp.getID());
			coursePlanRepo.save(toUpdate);
		} else {
			String msg = String.format("The course plan id %d is not found.", cp_id);
			throw new ResourceNotFoundException(msg);
		}
		
		return oldCp;
	}

	@Override
	public CoursePlan deleteCoursePlan(Long cp_id) {
		CoursePlan oldCp = getCoursePlanById(cp_id);
		
		if(oldCp != null) {
			//toUpdate.setID(oldCp.getID());
			coursePlanRepo.deleteById(cp_id);
		} else {
			String msg = String.format("The course plan id %d is not found.", cp_id);
			throw new ResourceNotFoundException(msg);
		}
		
		return oldCp;
	}

	@Override
	public CoursePlan getCoursePlanById(Long cp_id) {
		
		Optional<CoursePlan> cp = coursePlanRepo.findById(cp_id);
		
		if(cp.isPresent()) {
			return cp.get();
		}
		
		return null;
	}

	@Override
	public List<CoursePlan> getCoursePlanByStudent(Long stu_id) {

		List<CoursePlan> coursePlans = coursePlanRepo.findByStudentID(stu_id);
				
		return coursePlans;
	}

	@Override
	public List<CoursePlan> getAllCoursePlans() {

		return coursePlanRepo.findAll();
	}

}
