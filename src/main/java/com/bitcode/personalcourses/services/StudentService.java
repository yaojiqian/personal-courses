package com.bitcode.personalcourses.services;

import java.util.List;

import com.bitcode.personalcourses.model.Student;

public interface StudentService {
	
	public Student addStudent(Student std);
	public Student deleteStudent(long id);
	public Student updateStudent(Student newStd);
	public List<Student> getAllStudents();
	public Student getStudentById(long id);

}
