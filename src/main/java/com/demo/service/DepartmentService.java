package com.demo.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.demo.model.Department;

public interface DepartmentService {
	 List<Integer> findQuantity();
	 
	 Department save(Department d);
	 
	 Department findByDepartment(String book_dept);
}
