package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.model.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer>
{
		Admin save(Admin a);
		
		@Query("SELECT u FROM Admin u WHERE u.username = :username AND u.password = :password")
		Admin findAdminByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

		

}
