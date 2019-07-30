package com.bitcode.personalcourses.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "institutions")
@EntityListeners(AuditingEntityListener.class)
public class Institution {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;
	
	@NotBlank
	private String name;
	
	private char is_individual;
	
	private String contact;
	
	private String phone1;
	
	private String phone2;
	
	private String address;
	
	private Double balance;
	
	private Double total_amount;
	
	private Double account_balance;
	
	public Long getID() {
		return ID;
	}
	public void setID(Long intitutionId) {
		this.ID = intitutionId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String n) {
		this.name = n;
	}
	
	public char getIs_individual() {
		return is_individual;
	}
	
	public void setIs_individual(char is_individual) {
		this.is_individual = is_individual;
	}
	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public Double getTotal_amount() {
		return total_amount;
	}
	
	public void setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}
	
	public Double getAccount_balance() {
		return account_balance;
	}
	
	public void setAccount_balance(Double account_balance) {
		this.account_balance = account_balance;
	}
}
