package com.springStudentManagementSystem.StudentManagementSystem.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Principal {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int principalId;
	private String principalName;
	@Column(unique=true, nullable=false)
	private String principalEmail;
	@Column(unique=true, nullable=false)
	private Long principalPhone;
	private double principalSalary;
	@OneToMany(mappedBy="principal", cascade=CascadeType.ALL)
	private List<Teacher> listOfTeachers;
	
	public List<Teacher> getListOfTeachers() {
		return listOfTeachers;
	}
	public void setListOfTeachers(List<Teacher> listOfTeachers) {
		this.listOfTeachers = listOfTeachers;
	}
	
	
	public int getPrincipalId() {
		return principalId;
	}
	public void setPrincipalId(int principalId) {
		this.principalId = principalId;
	}
	public String getPrincipalName() {
		return principalName;
	}
	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}
	public String getPrincipalEmail() {
		return principalEmail;
	}
	public void setPrincipalEmail(String principalEmail) {
		this.principalEmail = principalEmail;
	}
	public Long getPrincipalPhone() {
		return principalPhone;
	}
	public void setPrincipalPhone(Long principalPhone) {
		this.principalPhone = principalPhone;
	}
	public double getPrincipalSalary() {
		return principalSalary;
	}
	public void setPrincipalSalary(double principalSalary) {
		this.principalSalary = principalSalary;
	}
	
}
