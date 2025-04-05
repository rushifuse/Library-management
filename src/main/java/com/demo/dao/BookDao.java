package com.demo.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Books;

@Repository
public interface BookDao extends JpaRepository<Books, Integer>
{
		Books save(Books b);
		
		
		@Query("SELECT DISTINCT b.book_dept FROM Books b")
	    List<String> findDistinctDepartments();
		
		@Query("SELECT  d.book_quantity FROM Department d")
	    List<Integer> findQuantity();
		
		@Query(value = "select book_id ,book_name , author_name, book_dept from Books_details where  book_name = ?1", nativeQuery = true)
		Books findByName(String book_name);
		
		
		@Query(value="update Books_details set book_name=?1 ,author_name=?2,book_dept=?3",nativeQuery = true)
		@Modifying
		int updateByBooks(String book_name,String author_name, String book_dept);
		
		@Query(value = "delete from Books_details where book_name = ?1", nativeQuery = true)
		@Modifying
		int deleteByName(String book_name);


		@Query("SELECT DISTINCT b.book_name FROM Books b WHERE b.book_dept = ?1")
		List<String> findBookList(String book_dept);

		
		
		
		
		
		
}
