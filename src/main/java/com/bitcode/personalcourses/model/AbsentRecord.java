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

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "absent_records")
@EntityListeners(AuditingEntityListener.class)
public class AbsentRecord {
	
	//private Logger logger = LoggerFactory.getLogger(AbsentRecordService.class);
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cou_ID", nullable = false)
	@JsonIgnore
	private CoursePlan coursePlan;
	
	private Date absent_date;
	
	private String memo;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public CoursePlan getCoursePlan() {
		return coursePlan;
	}

	public void setCoursePlan(CoursePlan coursePlan) {
		this.coursePlan = coursePlan;
	}

	public Date getAbsent_date() {
		return absent_date;
	}

	public void setAbsent_date(Date absent_date) {
		this.absent_date = absent_date;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}
