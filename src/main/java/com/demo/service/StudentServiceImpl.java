package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.demo.dao.DepartmentDao;
import com.demo.dao.StudentDao;

import com.demo.model.Department;
import com.demo.model.Student;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService,  DepartmentService{

	@Autowired
	private StudentDao sd;
	

	
	@Autowired
	private DepartmentDao dd;
	
	@Override
	public Student save(Student s) {
	return sd.save(s);
	}

	@Override
	public Student findByEmailAndPassword(String email, String password) {
		return sd.findByEmailAndPassword(email, password);
	}

	
	@Override
	public List<Integer> findQuantity() {
		return dd.findQuantity();
	}

	
	@Override
	public Department save(Department d) {
		return dd.save(d);
	}

	@Override
	public byte[] findImageBydName(String name) {
	return sd.findImageBydName(name);
	}

	@Override
	public Student findByName(String name) {
		return sd.findByName(name);
	}

	@Override
	public Student findByEmail(String email) {
		return sd.findByEmail(email);
	}

	@Override
	public int updateByStudent(String name, String email, String password, String dept, String oldEmail) {
		return sd.updateByStudent(name, email, password, dept, oldEmail);
	}

	@Override
	public Department findByDepartment(String book_dept) {
		return dd.findByDepartment(book_dept);
	}

	@Override
	public List<Student> findAll() {
		return sd.findAll();
	}

	@Override
	public String findDeptByEmail(String email) {
		return sd.findDeptByEmail(email);
	}

	

	
	
}
