package com.bitcode.personalcourses.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcode.personalcourses.exception.ResourceNotFoundException;
import com.bitcode.personalcourses.model.AttendRecord;
import com.bitcode.personalcourses.model.Student;
import com.bitcode.personalcourses.model.Tutor;
import com.bitcode.personalcourses.repository.AttendRecordRepository;
import com.bitcode.personalcourses.repository.StudentRepository;
import com.bitcode.personalcourses.repository.TutorRepository;

@Service
public class AttendRecordServiceImpl implements AttendRecordService {
	
	private AttendRecordRepository attendRecordRepo;
	private StudentRepository studentRepo;
	private TutorRepository tutorRepo;
	
	@Autowired
	public void setAttendRecordRepository(AttendRecordRepository arp) {
		attendRecordRepo = arp;
	}
	
	@Autowired
	public void setAttendRecordRepository(StudentRepository sp) {
		studentRepo = sp;
	}
	
	@Autowired
	public void setAttendRecordRepository(TutorRepository tp) {
		tutorRepo = tp;
	}
	
	@Override
	public AttendRecord addAttendRecord(Long stu_id, Long tut_id, AttendRecord att_r) {

		Optional<Student> student = studentRepo.findById(stu_id);
		
		if(!student.isPresent()) {
			throw new ResourceNotFoundException("Can't find the student.");
		}
		
		Optional<Tutor> tutor = tutorRepo.findById(tut_id);
		
		if(!tutor.isPresent()) {
			throw new ResourceNotFoundException("can't find the tutor");
		}
		
		att_r.setStudent(student.get());
		att_r.setTutor(tutor.get());
		
		AttendRecord newAtt = attendRecordRepo.save(att_r);

		return newAtt;
	}

	@Override
	public AttendRecord updateAttendRecord(Long att_id, AttendRecord toUpdate) {

		Optional<AttendRecord> oldAtt = attendRecordRepo.findById(att_id);
		
		if(!oldAtt.isPresent()) {
			throw new ResourceNotFoundException("Attend record is not found");
		}
		
		toUpdate.setID(oldAtt.get().getID());
		
		attendRecordRepo.save(toUpdate);
		
		return oldAtt.get();
	}

	@Override
	public AttendRecord deleteAttendRecord(Long att_id) {

		attendRecordRepo.deleteById(att_id);
		return null;
	}

	@Override
	public AttendRecord getAttendRecordById(Long att_id) {

		Optional<AttendRecord> oldAtt = attendRecordRepo.findById(att_id);
		
		if(!oldAtt.isPresent()) {
			throw new ResourceNotFoundException("Attend record is not found");
		}
		
		return oldAtt.get();
	}

	@Override
	public List<AttendRecord> getAttendRecordByStudent(Long stu_id) {
		
		return attendRecordRepo.findByStudentID(stu_id);
	}

	@Override
	public List<AttendRecord> getAttendRecordByTutor(Long tut_id) {

		return attendRecordRepo.findByTutorID(tut_id);
	}

	@Override
	public List<AttendRecord> getAllAttendRecords() {

		return attendRecordRepo.findAll();
	}
}
