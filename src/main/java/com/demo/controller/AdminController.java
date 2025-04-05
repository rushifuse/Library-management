package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Books;
import com.demo.service.AdminService;
import com.demo.service.BookService;
import com.demo.service.DepartmentService;

import jakarta.servlet.annotation.MultipartConfig;

@Controller
@MultipartConfig(maxFileSize = 999999999 , maxRequestSize = 999999999)
public class AdminController 
{
	@Autowired
	private AdminService as;
	
	@Autowired
	private BookService bs;
	
	@Autowired
	private DepartmentService ds;
	
	
	@PostMapping(value = {"/admin"})
	public ModelAndView a1(ModelAndView m , String username , String password)
	{
		if(username.equals(username) && password.equals(password))
		{
			m.setViewName("admin.jsp");
		}
		
		return m;
	}
	
	
	@PostMapping(value = {"/operation"})
	public ModelAndView a2(ModelAndView m, @RequestParam("b1") String b1) {
	    if (b1.equalsIgnoreCase("add")) {
	        m.setViewName("add_book.jsp");
	    } else if (b1.equalsIgnoreCase("display")) {
	        m.setViewName("display_book.jsp");
	    }
	    
	    return m;
	}
	
	
	@PostMapping(value = {"/bookDelete"})
	public ModelAndView a3(ModelAndView m ,String b1)
	{
		if(b1.equalsIgnoreCase("delete"))
		{
			m.setViewName("delete_book.jsp");
		}
		return m;
	}
	
	@PostMapping(value = {"/deleteCheck"})
	public ModelAndView a4(ModelAndView m, String book_name, String b1) {
	    if (b1.equalsIgnoreCase("check")) {
	        int a = bs.deleteByName(book_name);
	        if (a !=0) {
	        	 m.addObject("msg", " book "+ book_name+" delete successfully !!! " );
		            m.setViewName("delete_book.jsp");
	        } else {
	            m.addObject("msg", "No book found with the name: " + book_name);
	            m.setViewName("delete_book.jsp");
	        }
	    }
	    return m;
	}

	


	
	@PostMapping(value = "/adminBookList")
	public ModelAndView a7(
	    ModelAndView m, 
	     String b
	) {
	   
	        List<String> books = bs.findBookList(b);
	        m.addObject("book", books);
	        m.setViewName("bookListAdmin.jsp");
	    
	    return m;
	}
	
	@PostMapping(value = "/{b}")
	public ModelAndView a10(
	    ModelAndView m, 
	    @PathVariable String b
	) {
	   
	        List<String> books = bs.findBookList(b);
	        m.addObject("book", books);
	        m.setViewName("bookList.jsp");
	    
	    return m;
	}
	
	
	
	@GetMapping(value = "/AdminbookList")
	public ModelAndView a8(
	       ModelAndView m,
	       @RequestParam("b") String b,
	       @RequestParam(name = "actionType", required = false) String actionType // Renamed from 'view'
	) {
	    if ("view".equals(actionType)) {
	        List<String> books = bs.findBookList(b);
	        m.addObject("book", books);
	    }
	    m.setViewName("bookListAdmin.jsp");
	    return m;
	}
	@GetMapping(value = {"/back2"})
	public ModelAndView m15(ModelAndView m , String back)
	{
			m.setViewName("admin.jsp");
		return m;
	}
	
	@GetMapping(value = {"/adminLoginPage"})
	public ModelAndView m16(ModelAndView m)
	{
		m.setViewName("adminLogin.jsp");
		return m;
	}

	
	
	
	@GetMapping(value = {"/mainpage"})
	public ModelAndView m17(ModelAndView m)
	{
		m.setViewName("main.jsp");
		return m;
	}
	
}
