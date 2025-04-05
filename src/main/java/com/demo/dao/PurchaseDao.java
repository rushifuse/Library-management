package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.model.Purchase;

@Repository
public interface PurchaseDao extends JpaRepository<Purchase, Integer>
{
	Purchase save(Purchase p);
	
	@Query("SELECT p.book_name FROM Purchase p WHERE p.student_name = :student_name")
    List<String> findPurchasedBooksByStudent(String student_name);
	
	List<Purchase> findAll();
	
	@Query(value = "select * from Purchase where email = ?1", nativeQuery =  true)
	List<Purchase> findBookByEmail(String email);
	
	@Query(value = "select * from Purchase where book_name = ?1", nativeQuery =  true)
	List<Purchase> findBookByBookName(String book_name);
	
	@Query(value = "select * from Purchase where book_name = ?1", nativeQuery =  true)
	List<Purchase> findEmailByBookName(String book_name);
	 
	 Purchase findByEmail(String email);
	 
	 @Query("SELECT p FROM Purchase p WHERE p.email = :email AND p.book_name = :book_name")
	    Purchase findByEmailAndBookName(@Param("email") String email, @Param("book_name") String book_name);
	 
	 
}
