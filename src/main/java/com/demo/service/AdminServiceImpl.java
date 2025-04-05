package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.AdminDao;
import com.demo.dao.StudentDao;
import com.demo.model.Admin;
import com.demo.model.Student;

@Service
@Transactional
public class AdminServiceImpl implements AdminService 
{
	@Autowired
	private AdminDao ad;
	
	@Autowired
	private StudentDao sd;

	@Override
	public Admin save(Admin a) {
		return ad.save(a);
	}


	@Override
	public Admin findAdminByUsernameAndPassword(String username, String password) {
		return ad.findAdminByUsernameAndPassword(username, password);
	}


}
