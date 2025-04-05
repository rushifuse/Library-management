package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.BookDao;
import com.demo.dao.DepartmentDao;
import com.demo.model.Books;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bd;
	
	
	
	
	@Override
	public Books save(Books b) {
		return bd.save(b);
	}

	@Override
	public List<String> findDistinctDepartments() {
		return bd.findDistinctDepartments();
	}


	@Override
	public Books findByName(String book_name) {
	return bd.findByName(book_name);
	}

	@Override
	public int updateByBooks(String book_name, String author_name, String book_dept) {
		return bd.updateByBooks(book_name, author_name, book_dept);
	}

	@Override
	public int deleteByName(String book_name) {
		return bd.deleteByName(book_name);
	}

	@Override
	public List<String> findBookList(String book_dept) {
		return bd.findBookList(book_dept);
	}

}
