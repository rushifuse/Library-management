package com.demo.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.demo.model.Purchase;
import com.demo.model.Student;

public interface PurchaseService {
	Purchase save(Purchase p);
	
	  List<String> findPurchasedBooksByStudent(String student_name);
	  
	  List<Purchase> findAll();
	  
		List<Purchase> findBookByEmail(String email);
		
		List<Purchase> findBookByBookName(String book_name);
		
		List<Purchase> findEmailByBookName(String book_name);
		
		 Purchase findByEmail(String email);
		   Purchase findByEmailAndBookName(@Param("email") String email, @Param("book_name") String book_name);
}
