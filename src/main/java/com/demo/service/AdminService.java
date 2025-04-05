package com.demo.service;

import org.springframework.data.repository.query.Param;

import com.demo.model.Admin;
import com.demo.model.Student;

public interface AdminService 
{
	Admin save(Admin a);
	
	Admin findAdminByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
	
	
}
