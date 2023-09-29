package com.springStudentManagementSystem.StudentManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springStudentManagementSystem.StudentManagementSystem.model.Principal;

public interface PrincipalRepo extends JpaRepository<Principal, Integer> {
	

}
