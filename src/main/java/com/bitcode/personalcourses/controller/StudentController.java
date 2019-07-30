package com.bitcode.personalcourses.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcode.personalcourses.exception.ResourceNotFoundException;
import com.bitcode.personalcourses.model.Student;
import com.bitcode.personalcourses.services.StudentService;

@CrossOrigin(origins = {"*", "null"})
@RestController
@RequestMapping("/api")
public class StudentController {
	
	private StudentService studentService;
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	public void setStudentService(StudentService ss) {
		this.studentService = ss;
	}
	
	@GetMapping("/Students")
	public List<Student> getAllStudents() throws ResourceNotFoundException {
		
		logger.debug("/Students Get");
		List<Student> rl = studentService.getAllStudents();
		
		if(rl.isEmpty()) {
			throw new ResourceNotFoundException("There is not any students.");
		}
		
		return rl;
	}
	
	@GetMapping("/Students/{id}")
	public Student getStudent(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
		
		Student rt = studentService.getStudentById(id);
		
		if(rt == null) {
			throw new ResourceNotFoundException("Student not found.");
		}
		return rt;
	}
	
	@PostMapping("/Students")
	public Student postStudent(@Valid @RequestBody Student std) {
		logger.debug("/Students Post {}", std);
		return studentService.addStudent(std);
	}
	
	@PutMapping("/Students/{id}")
	public Student putStudent(@PathVariable(value="id") long id, @Valid @RequestBody Student std)
		throws ResourceNotFoundException {
		
		std.setID(id);
		Student st = studentService.updateStudent(std);
		
		if(st == null) {
			throw new ResourceNotFoundException("Student not found.");
		}
		
		return st;
	}
	
	@DeleteMapping("/Students/{id}")
	public Student deleteStudent(@PathVariable(value="id") long id) throws ResourceNotFoundException {
		
		Student st = studentService.deleteStudent(id);
		if(st == null) {
			throw new ResourceNotFoundException("Student not found.");
		}
		
		return st;
	}

}
