package com.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Books_details")
public class Books 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int book_id;
	
	@Column(columnDefinition = "varchar(300)")
	private String book_name ;
	
	@Column(columnDefinition = "varchar(300)")
	private String author_name;
	
	@Column(columnDefinition = "varchar(300)")
	private String book_dept;
	
	public String getBook_dept() {
		return book_dept;
	}
	public void setBook_dept(String book_dept) {
		this.book_dept = book_dept;
	}
	@Override
	public String toString() {
		return "BooksDetails [book_id=" + book_id + ", book_name=" + book_name + ", author_name=" + author_name + ", book_dept="
				+ book_dept + "]";
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int id) {
		this.book_id = id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

}
