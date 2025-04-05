package com.demo.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dept_books")
public class Department 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(columnDefinition = "varchar(300)")
	private String book_dept ;
	
	private int book_quantity;
		
	

	@Override
	public String toString() {
		return "DeptBooks [id=" + id + ", book_dept=" + book_dept + ", book_quantity=" + book_quantity + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBook_dept() {
		return book_dept;
	}

	public void setBook_dept(String book_dept) {
		this.book_dept = book_dept;
	}

	public int getBook_quantity() {
		return book_quantity;
	}

	public void setBook_quantity(int book_quantity) {
		this.book_quantity = book_quantity;
	}
	
	}

