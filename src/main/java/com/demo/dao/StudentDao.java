package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer>
{
		Student save(Student s);
		
		Student findByEmailAndPassword(String email, String password);

		@Query(value = "select image from student_registration where lower(name) = lower(?1)", nativeQuery = true)
		byte[] findImageBydName(String name);


		Student findByName(String name);
		
		
		 Student findByEmail(String email);
		 
		 @Modifying
		 @Query(value = "UPDATE student_registration SET name = :name, email = :email, password = :password, dept = :dept WHERE email = :oldEmail", nativeQuery = true)
		 int updateByStudent(@Param("name") String name, 
		                      @Param("email") String email, 
		                      @Param("password") String password, 
		                      @Param("dept") String dept, 
		                      @Param("oldEmail") String oldEmail);

		 
		 List<Student> findAll();
		 
		 @Query("SELECT s.dept FROM Student s WHERE s.email = ?1")
		    String findDeptByEmail(String email);
}
