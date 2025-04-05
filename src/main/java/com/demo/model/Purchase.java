package com.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Purchase 
{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String student_name;
		private String book_name;
		private String submit;
		private String book_purchase;
		private String email;
		private LocalDate purchase_date;
		private LocalDate submission_date;
		
		public LocalDate getSubmission_date() {
			return submission_date;
		}
		public void setSubmission_date(LocalDate submission_date) {
			this.submission_date = submission_date;
		}
		public LocalDate getPurchase_date() {
			return purchase_date;
		}
		public void setPurchase_date(LocalDate purchase_date) {
			this.purchase_date = purchase_date;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getBook_purchase() {
			return book_purchase;
		}
		public void setBook_purchase(String book_purchase) {
			this.book_purchase = book_purchase;
		}
		public String getSubmit() {
			return submit;
		}
		public void setSubmit(String submit) {
			this.submit = submit;
		}
		@Override
		public String toString() {
			return "Purchase [id=" + id + ", student_name=" + student_name + ", book_name=" + book_name + ", submit="
					+ submit + ", book_purchase=" + book_purchase + ", email=" + email + ", purchase_date="
					+ purchase_date + ", submission_date=" + submission_date + "]";
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getStudent_name() {
			return student_name;
		}
		public void setStudent_name(String student_name) {
			this.student_name = student_name;
		}
		public String getBook_name() {
			return book_name;
		}
		public void setBook_name(String book_name) {
			this.book_name = book_name;
		}
		
		
}
