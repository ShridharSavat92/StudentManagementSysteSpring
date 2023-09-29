package com.springStudentManagementSystem.StudentManagementSystem.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int teacherId;
	private String teacherName;
	@Column(unique=true, nullable=false)
	private String teacherEmail;
	@Column(unique=true, nullable=false)
	private long teacherphone;
	private double teacherSalary;
	private String teacherCourse;
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Principal principal;
	@OneToMany(mappedBy="teacher", cascade=CascadeType.ALL)
	private List<Student> listOfStudent;
	
	public Principal getPrincipal() {
		return principal;
	}
	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}
	public List<Student> getListOfStudent() {
		return listOfStudent;
	}
	public void setListOfStudent(List<Student> listOfStudent) {
		this.listOfStudent = listOfStudent;
	}
	
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherEmail() {
		return teacherEmail;
	}
	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}
	public long getTeacherphone() {
		return teacherphone;
	}
	public void setTeacherphone(long teacherphone) {
		this.teacherphone = teacherphone;
	}
	public double getTeacherSalary() {
		return teacherSalary;
	}
	public void setTeacherSalary(double teacherSalary) {
		this.teacherSalary = teacherSalary;
	}
	public String getTeacherCourse() {
		return teacherCourse;
	}
	public void setTeacherCourse(String teacherCourse) {
		this.teacherCourse = teacherCourse;
	}
}
