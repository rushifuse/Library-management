package com.demo.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.demo.model.Student;

public interface StudentService {
	Student save(Student s);
	
	Student findByEmailAndPassword( String email , String password);
	
	
	byte[] findImageBydName(String name);
	
	Student findByName(String name);
	
	 Student findByEmail(String email);
	
	 int updateByStudent(@Param("name") String name, 
             @Param("email") String email, 
             @Param("password") String password, 
             @Param("dept") String dept, 
             @Param("oldEmail") String oldEmail);
	 
	 List<Student> findAll();
	 
	 String findDeptByEmail(String email);
}
