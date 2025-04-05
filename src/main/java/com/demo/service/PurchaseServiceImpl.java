package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.PurchaseDao;
import com.demo.model.Purchase;
import com.demo.model.Student;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService
{
	@Autowired
	private PurchaseDao pd;

	@Override
	public Purchase save(Purchase p) {
		return pd.save(p);
	}

	@Override
	public List<String> findPurchasedBooksByStudent(String student_name) {
		return pd.findPurchasedBooksByStudent(student_name);
	}

	@Override
	public List<Purchase> findAll() {
	return pd.findAll();
	}

	@Override
	public List<Purchase> findBookByEmail(String email) {
		return pd.findBookByEmail(email);
	}

	@Override
	public List<Purchase> findBookByBookName(String book_name) {
		return pd.findBookByBookName(book_name);
	}

	@Override
	public List<Purchase> findEmailByBookName(String book_name) {
		return pd.findEmailByBookName(book_name);
	}

	@Override
	public Purchase findByEmail(String email) {
		return pd.findByEmail(email);
	}

	@Override
	public Purchase findByEmailAndBookName(String email, String book_name) {
		return pd.findByEmailAndBookName(email, book_name);
	}

	
}
