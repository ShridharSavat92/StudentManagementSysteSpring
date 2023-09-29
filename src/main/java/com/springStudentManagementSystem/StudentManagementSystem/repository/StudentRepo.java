package com.springStudentManagementSystem.StudentManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springStudentManagementSystem.StudentManagementSystem.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	public List<Student> findByStudentEmail(String studentEmail);

}
