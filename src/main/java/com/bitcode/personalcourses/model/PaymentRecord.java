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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
CREATE TABLE payment_records
(
    ID INT NOT NULL AUTO_INCREMENT,
    ins_ID INT NOT NULL,
    pay_time DATE NOT NULL,
    amount DECIMAL(7,2) NOT NULL,		-- real amount paid.
    promotional_amount DECIMAL(7,2), 	-- promotional amount
    balance DECIMAL(10,2) NOT NULL,
    account_balance DECIMAL(10,2),		-- 
    PRIMARY KEY (ID),
    FOREIGN KEY (ins_ID) REFERENCES institutions(ID) ON DELETE CASCADE
) character set = utf8;
*/

@Entity
@Table(name="payment_records")
@EntityListeners(AuditingEntityListener.class)
public class PaymentRecord {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long ID;
	

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="ins_ID", nullable=false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JsonIgnore
	private Institution institution;
	
	
	private Date pay_time;
	
	private double amount;
	
	private double promotional_amount;
	
	private double balance;
	
	private double account_balance;

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

	public Date getPay_time() {
		return pay_time;
	}

	public void setPay_time(Date pay_time) {
		this.pay_time = pay_time;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getPromotional_amount() {
		return promotional_amount;
	}

	public void setPromotional_amount(double promotional_amount) {
		this.promotional_amount = promotional_amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAccount_balance() {
		return account_balance;
	}

	public void setAccount_balance(double account_balance) {
		this.account_balance = account_balance;
	}
}
