package com.demo.service;

import java.awt.print.Book;
import java.util.List;

import com.demo.model.Books;

public interface BookService 
{
	Books save(Books b);
	
	 List<String> findDistinctDepartments();
	 
	 Books findByName(String book_name);
	 
	 int updateByBooks(String book_name,String author_name, String book_dept);
	 
	int deleteByName(String book_name);
	 
	 
	List<String> findBookList(String book_dept);
	 
}
