package com.bitcode.personalcourses.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "course_plans")
@EntityListeners(AuditingEntityListener.class)
public class CoursePlan {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long ID;
	
	@NotBlank
	private String subject;
	
	private Date initial_date;
	
	private Date start_time;
	
	private float duration;
	
	private double fee;
	
	private char repeat_type;
	
	@ManyToOne(fetch= FetchType.LAZY, optional=false)
	@JoinColumn(name="stu_ID", nullable=false)
	@JsonIgnore()
	private Student student;
	
	@ManyToOne(fetch= FetchType.LAZY, optional=false)
	@JoinColumn(name="ins_ID", nullable=false)
	@JsonIgnore()
	private Institution institution;
	
	@ManyToOne(fetch= FetchType.LAZY, optional=false)
	@JoinColumn(name="tut_ID", nullable=false)
	@JsonIgnore()
	private Tutor tutor;

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getInitial_date() {
		return initial_date;
	}

	public void setInitial_date(Date initial_date) {
		this.initial_date = initial_date;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public char getRepeat_type() {
		return repeat_type;
	}

	public void setRepeat_type(char repeat_type) {
		this.repeat_type = repeat_type;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
}
