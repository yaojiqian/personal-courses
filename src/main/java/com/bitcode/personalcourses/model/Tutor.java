package com.bitcode.personalcourses.model;

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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;


/*
	CREATE TABLE tutors
	(
	    ID INT NOT NULL AUTO_INCREMENT,
	    ins_ID INT NOT NULL,			-- the institution to which this tutor belong.
	    name VARCHAR(20) NOT NULL,		
	    gender CHAR(1) NOT NULL,
	    subject VARCHAR(10) NOT NULL,
	    fee DECIMAL(5,2),
	    contact VARCHAR(100),			-- could include phone number, wechat, QQ and so on.
	    memo VARCHAR(200),
	    PRIMARY KEY(ID),
	    FOREIGN KEY(ins_ID) REFERENCES institutions(ID) ON DELETE CASCADE
	);
 */

@Entity
@Table(name="Tutors")
@EntityListeners(AuditingEntityListener.class)
public class Tutor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="ins_ID", nullable=false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JsonIgnore
	private Institution institution;
	
	@NotBlank
	private String name;
	
	@NotNull
	private char gender;

	@NotBlank
	private String subject;
	
	private String contact;
	
	private String memo;

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}
