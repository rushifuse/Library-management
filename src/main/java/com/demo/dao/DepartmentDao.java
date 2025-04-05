package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.model.Department;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer>
{
	@Query(value = "select book_quantity from dept_books" , nativeQuery = true)
	 List<Integer> findQuantity();

	@Query(value = "SELECT * FROM Department WHERE book_dept = ?1", nativeQuery = true)
	Department findByDepartment(String book_dept);

	Department save(Department d);
	
	
}
