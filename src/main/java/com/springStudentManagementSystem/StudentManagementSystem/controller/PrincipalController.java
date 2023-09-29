package com.springStudentManagementSystem.StudentManagementSystem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springStudentManagementSystem.StudentManagementSystem.model.Principal;
import com.springStudentManagementSystem.StudentManagementSystem.model.Student;
import com.springStudentManagementSystem.StudentManagementSystem.model.Teacher;
import com.springStudentManagementSystem.StudentManagementSystem.repository.PrincipalRepo;
import com.springStudentManagementSystem.StudentManagementSystem.repository.StudentRepo;
import com.springStudentManagementSystem.StudentManagementSystem.repository.TeacherRepo;

@RestController
public class PrincipalController {
	@Autowired
	PrincipalRepo principalRepo;
	
	@Autowired
	TeacherRepo teacherRepo;
	
	@Autowired
	StudentRepo studentRepo;
	
	@PostMapping("/SavePrincipalRecords")
	public Principal savePrincipalRecords(@RequestBody  Principal principal) {
		List<Teacher> teachers=principal.getListOfTeachers();
		List<Teacher> resultTeacher=new ArrayList<Teacher>();
		
		if(teachers.isEmpty()) {
			principal=principalRepo.save(principal);
		}else {
			principal=principalRepo.save(principal);
			for(Teacher teacher:teachers) {
				teacher.setPrincipal(principal);
				resultTeacher.add(teacherRepo.save(teacher));
				
				List<Student> students=teacher.getListOfStudent();
				List<Student> resultStudent=new ArrayList<Student>();
				
				if(students.isEmpty()) {
					teacher=teacherRepo.save(teacher);
				}else {
					teacher=teacherRepo.save(teacher);
					for(Student student:students) {
						student.setTeacher(teacher);
						 resultStudent.add(studentRepo.save(student));
					}
					
					teacher.setListOfStudent(resultStudent);
				}
				
			}
			principal.setListOfTeachers(teachers);
		}
		
		return principal;
	}
	
	@GetMapping("/GetPrincipleRecords")
	public Optional<Principal> getPrincipalRecords(@RequestParam int id) {
		return principalRepo.findById(id);
	}
	
	@PutMapping("/UpdatePrincipleRecords")
	public Principal updatePrincipalRecords(@RequestBody Principal  principal) {
		return principalRepo.save(principal);
	}
	
	@DeleteMapping("/DeletePrincipleRecords")
	public String deleteRecords(int id) {
		Optional<Principal> records=principalRepo.findById(id);
		if(records.isPresent()) {
			principalRepo.deleteById(id);
			return "Records successfully deleted";
		}
		
		return "Records not found";
	}
	
	@GetMapping("GetTeacherRecordsByName")
	public List<Teacher> getTeacherRecords(@RequestParam String teacherName) {
		return teacherRepo.findByTeacherName(teacherName);
	}
	
	@GetMapping("GetStudentRecordsByEmail")
	public List<Student> getStudentRecords(@RequestParam String email){
		return studentRepo.findByStudentEmail(email);
	}
	
	@PutMapping("UpdateRecordsOfStudent")
	public Student updateStudentRecords(@RequestBody Student student) {
		return studentRepo.save(student);
	}
	
	@PutMapping("UpdateRecordsOfTeacher")
	public Teacher updateTeacherRecords(@RequestBody Teacher teacher) {
		return teacherRepo.save(teacher);
	}
	
	@DeleteMapping("DeleteRecordsOfStudent")
	public String deleteStudentRecords(@RequestParam int id){
		Optional<Student> recordsOfStudent=studentRepo.findById(id);
		if(recordsOfStudent.isPresent()) {
			studentRepo.deleteById(id);
			return "Records deleted successfully";
		}
		
		return "Records not found";
		
	}
	
	@DeleteMapping("DeleteRecordsOfTeacher")
	public String deleteTeacherRecords(@RequestParam int id){
		Optional<Teacher> recordsOfTeacher=teacherRepo.findById(id);
		if(recordsOfTeacher.isPresent()) {
			teacherRepo.deleteById(id);
			return "Records deleted successfully";
		}
		
		return "Records not found";
		
	}
	
}
