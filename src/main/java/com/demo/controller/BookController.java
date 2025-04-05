package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Books;
import com.demo.service.BookService;
import com.demo.service.DepartmentService;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.annotation.MultipartConfig;

@Controller
@MultipartConfig(maxFileSize = 999999999 , maxRequestSize = 999999999)
public class BookController 
{
	@Autowired
	private BookService bs;
	
	@Autowired
	private DepartmentService ds;
	
	@PostMapping(value = {"/addBook"})
	public ModelAndView b1(ModelAndView m, String book_name,String author_name , String book_dept , String bookAdd)
	{
		if(bookAdd.equalsIgnoreCase(bookAdd))
			{ 
			     Books b1 = bs.findByName(book_name);
			     if(b1==null)
			     {
			    	 Books b = new Books();
						b.setBook_name(book_name);
						b.setAuthor_name(author_name);
						b.setBook_dept(book_dept);
						
						bs.save(b);	
						
						m.addObject("msg", "Book Added Successfully  !!!!");
						m.setViewName("admin.jsp");
			     }
			     else {
			    	 
			    	m.addObject("msg", "Book Is Already Added  !!!!");
					m.setViewName("admin.jsp");
			     }
			
			
		}
		return m ;
	}
	
	@PostMapping(value = {"/check"})
	public ModelAndView b1(ModelAndView m, String book_name, String check) {
	    if (check.equalsIgnoreCase("check")) {
	        Books book = bs.findByName(book_name);
	        if (book != null) {
	            m.addObject("book", book);
	            System.out.println("Book found: " + book);
	        } else {
	            m.addObject("msg", "No book found with the name: " + book_name);
	            System.out.println("No book found.");
	        }
	        m.setViewName("display_book.jsp");
	    }
	    return m;
	}
	
	
	
	
	@PostMapping(value = {"/update"})
	public ModelAndView b2(ModelAndView m, String book_name,String author_name ,String book_dept ,String update)
	{
		if(update.equalsIgnoreCase("update"))
		{
		
			int a=  bs.updateByBooks(book_name, author_name, book_dept);
			if(a!=0)
			{
				m.addObject("msg", "updated book ssuccessfully !!!");
				m.setViewName("display_book.jsp");
			}
			m.setViewName("display_book.jsp");
			
		}
		return m ;
	}
	

	
	
}
