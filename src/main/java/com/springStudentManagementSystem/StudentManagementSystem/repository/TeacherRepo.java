package com.springStudentManagementSystem.StudentManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springStudentManagementSystem.StudentManagementSystem.model.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher, Integer> {
	public List<Teacher> findByTeacherName(String teacherName);

}
