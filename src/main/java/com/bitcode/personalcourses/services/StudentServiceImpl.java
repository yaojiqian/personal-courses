package com.bitcode.personalcourses.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcode.personalcourses.model.Student;
import com.bitcode.personalcourses.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepo;
	
	@Autowired
	public void setStudentRepository(StudentRepository stdRepo) {
		
		this.studentRepo = stdRepo;
	}
	
	@Override
	public Student addStudent(Student std) {
		
		return studentRepo.save(std);
	}

	@Override
	public Student deleteStudent(long id) {

		Student toDel = getStudentById(id);
		
		if(toDel != null) {
			studentRepo.deleteById(id);
		}		
		
		return toDel;
	}

	@Override
	public Student updateStudent(Student newStd) {

		long id = newStd.getID();
		
		Student toUpdate = getStudentById(id);
		if(toUpdate != null) {
			studentRepo.save(newStd);
		}
		
		return toUpdate;
	}

	@Override
	public List<Student> getAllStudents() {

		return studentRepo.findAll();
	}

	@Override
	public Student getStudentById(long id) {

		Optional<Student> found = studentRepo.findById(id);
		
		if(found.isPresent()) {
			return found.get();
		}
		
		return null;
	}

}
