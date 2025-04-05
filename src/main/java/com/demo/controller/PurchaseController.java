package com.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Purchase;
import com.demo.model.Student;
import com.demo.service.BookService;
import com.demo.service.PurchaseService;
import com.demo.service.StudentService;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.annotation.MultipartConfig;

@Controller
@MultipartConfig(maxFileSize = 999999999 , maxRequestSize = 999999999)
public class PurchaseController 
{
	   @Autowired
	    private StudentController sc;
	   
	   @Autowired
	   BookService bs;
	   
	   @Autowired
	   StudentService ss;
	   
	   @Autowired
	   PurchaseService ps;
	   
	   @PostMapping(value = {"/purchase"})
	   public ModelAndView purchaseBook(ModelAndView model, String book_name, String b1) {
	       String email = sc.msg1;
	       String password = sc.msg2;


	       if (email == null || password == null) {
	           model.addObject("msg", "Session expired. Please log in again. !!!!!");
	           model.setViewName("login.jsp");
	           return model;
	       }

	       Student student = ss.findByEmailAndPassword(email, password);

	       
	       if (student == null) {
	           model.addObject("msg", "Invalid credentials. Please log in again. !!!!!");
	           model.setViewName("login.jsp");
	           return model;
	       }

	      
	       List<String> purchasedBooks = ps.findPurchasedBooksByStudent(student.getName());

	       
	       if (purchasedBooks.contains(book_name)) {
	    	   
	    	 
	    	   model.addObject("bookList", purchasedBooks);
	           
	           model.addObject("purchasedBook", book_name); 
	           model.addObject("msg", "Book is already purchased. !!!!!");
	           model.setViewName("bookList.jsp");
	           return model;
	       }

	  
	       Purchase purchase = new Purchase();
	       purchase.setEmail(email);
	       purchase.setBook_purchase("Purchase");
	       purchase.setSubmit("pending");
	       purchase.setBook_name(book_name);
	       purchase.setStudent_name(student.getName());
	       purchase.setPurchase_date(LocalDate.now());

	       Purchase savedPurchase = ps.save(purchase);

	       if (savedPurchase != null) {
	           String dept = ss.findDeptByEmail(email);
	           List<String> bookList = bs.findBookList(dept);

	           model.addObject("bookList", purchasedBooks);
	           model.addObject("book", bookList);
	           model.addObject("purchasedBook", book_name); 
	           model.setViewName("bookList.jsp");
	       }

	       return model;
	   }

	   
	   
	   @GetMapping(value = {"/studentPurchaseList"})
	   public ModelAndView p2(ModelAndView m , String book_name)
	   {
		   List<Purchase> list = ps.findBookByBookName(book_name);
		   m.addObject("purchase",list);
		   m.setViewName("purchaseList.jsp");
		   return m;
	   }
	   
		
	   @PostMapping(value = {"/studentWantTosubmit"})
	   public ModelAndView p3(ModelAndView m )
	   {
		 
		   m.setViewName("submitBook.jsp");
		   return m;
	   }
	   
		
	   @PostMapping(value = {"/bookSubmit"})
	   public ModelAndView p4(ModelAndView m, String email, String book_name) {
		 
		    List<Purchase> list = ps.findEmailByBookName(book_name);

		  
		    boolean isPurchasedByEmail = list.stream().anyMatch(p -> p.getEmail().equals(email));

		    if (isPurchasedByEmail) {     // Find the specific purchase record for this email and book
		        Purchase purchase = ps.findByEmailAndBookName(email, book_name);
		        if (purchase != null) {
		          
		            purchase.setSubmit("Submited"); 
		            purchase.setSubmission_date(LocalDate.now());
		            ps.save(purchase);  

		            m.addObject("msg", "Book submission successful!");
		        } else {
		            m.addObject("msg", "Error updating submission status.");
		        }
		    } else {
		        m.addObject("msg", "No purchase record found for this book with the given email.");
		    }

		    m.setViewName("submitBook.jsp");
		    return m;
		}
}
