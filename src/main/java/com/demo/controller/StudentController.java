package com.demo.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Purchase;
import com.demo.model.Student;
import com.demo.service.BookService;
import com.demo.service.DepartmentService;
import com.demo.service.PurchaseService;
import com.demo.service.StudentService;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@MultipartConfig(maxFileSize = 999999999 , maxRequestSize = 999999999)
public class StudentController 
{
	String msg1;
	 String msg2;
	@Autowired
	private StudentService ss;

	@Autowired
	private BookService bs;
	
	@Autowired
	private DepartmentService ds;
	
	@Autowired
	private PurchaseService ps;
	
	@GetMapping(value = { "/index"})
	public ModelAndView m1(ModelAndView m)
	{
		m.setViewName("index.jsp");
		return m;
	}
	@GetMapping(value = {"/"})
	public ModelAndView m34(ModelAndView m)
	{
		m.setViewName("main.jsp");
		return m;
	}
	
	
	@PostMapping(value = {"/login"})
	public ModelAndView m2(ModelAndView m, String email, String password, String login) {
	  
	

	    if (login != null && login.equalsIgnoreCase("login")) {
	
	        Student s = ss.findByEmailAndPassword(email, password);
	        if (s != null && s.getEmail().equals(email) && s.getPassword().equals(password)) {
	        	msg1 = s.getEmail();
	        	msg2 = s.getPassword();
	        
	            m.setViewName("studentHome.jsp");
	            return m;
	        }else
	        {
	        	m.addObject("msg", "Please Enter Valid Email And Password !!!!");
	        	m.setViewName("login.jsp");
	        }
	    }

	    m.setViewName("login.jsp");
	    return m;
	}


	
	@PostMapping(value = {"/signUp"})
	public ModelAndView m3(ModelAndView m , String name ,  String email, String password , String dept , MultipartFile image , String submit) throws IOException
	{
	
		Student s1 = ss.findByEmailAndPassword(email, password);
		Student s2 = ss.findByEmail(email);
		Student s3 = ss.findByName(name);
		if( s1 != null ||  s2!= null || s3 != null)
		{
			m.addObject("msg", "Student Already Exits !!!!");
			m.setViewName("sign_up.jsp");
		}
		else
		{
		
			
			Student s = new Student();
			s.setName(name);
			s.setEmail(email);
			s.setPassword(password);
			s.setDept(dept);
			s.setImage(image.getBytes());
			s.setStd_id(s.getDept()+s.getId());			
			System.out.println(ss.save(s));
			m.addObject("msg", " Registration successfully   !!!!");
			m.setViewName("sign_up.jsp");
		}
		
		
		return m;
	}
	
	
	@PostMapping(value = {"/home"})
	public ModelAndView m0(ModelAndView m)
	{
		m.addObject("book", bs.findDistinctDepartments());
    	m.addObject("quantity",ds.findQuantity());
		m.setViewName("home.jsp");
		return m;
	}
	

	
	
	
	@PostMapping(value = {"/studentCheck"})
	public ModelAndView m6(ModelAndView m , String name)
	{
		Student s = ss.findByName(name);
		m.addObject("student", s);
		m.setViewName("profile.jsp");
		return m;
	}
	
	@GetMapping(value = {"findImage/{name}"})
	public void m7( @PathVariable String name , HttpServletResponse res) throws IOException
	{
		OutputStream o1 = res.getOutputStream();
		res.setContentType("image/jpeg");
		o1.write(ss.findImageBydName(name));
		o1.flush();
		o1.close();
	}

	@PostMapping(value = {"/studentOperaton"})
	public ModelAndView m8(ModelAndView m, String b1) {
	 if(b1.equalsIgnoreCase("dept"))
	{
		m.addObject("book", bs.findDistinctDepartments());
    	m.addObject("quantity",ds.findQuantity());
        m.setViewName("home.jsp");
		
	}


	return m;
	
	}
	
	
	@PostMapping(value = {"/profile"})
	public ModelAndView m9(ModelAndView m) {
		Student s = ss.findByEmailAndPassword(msg1, msg2);
		List<Purchase> list = ps.findBookByEmail(msg1) ;
		
		m.addObject("purchase", list);
		m.addObject("student", s);
        m.setViewName("profile.jsp");

	return m;
	
	}
	
	@PostMapping("/updateStudent")
	public ModelAndView updateStudent(@RequestParam("name") String name,
	                                   @RequestParam("email") String email,
	                                   @RequestParam("password") String password,
	                                   @RequestParam("dept") String dept,
	                                   @RequestParam(value = "image", required = false) MultipartFile image,
	                                   HttpServletRequest request, ModelAndView m) throws IOException {
	    
	    Student s = ss.findByEmailAndPassword(msg1, msg2);
	    if (s == null) {
	        m.addObject("msg", "Student not found with given credentials");
	        m.setViewName("error.jsp");
	        return m;
	    }

	   
	    s.setName(name);
	    s.setEmail(email);
	    s.setPassword(password);
	    s.setDept(dept);

	   
	    if (image != null && !image.isEmpty()) {
	        s.setImage(image.getBytes());
	    } else {
	       
	        s.setImage(ss.findImageBydName(name));
	    }

	   
	    ss.save(s);

	    m.addObject("msg", "Student details updated successfully!");
	    m.setViewName("login.jsp");
	    return m;
	}

	
	@PostMapping(value = {"/studentUpdate"})
	public ModelAndView m11(ModelAndView m )
	{
		Student s = ss.findByEmailAndPassword(msg1, msg2);
		m.addObject("student", s);
		m.setViewName("update_student.jsp");
		return m;
	}
	
	@PostMapping(value = {"/studentList"})
	public ModelAndView m12(ModelAndView m )
	{
		List<Student>list = ss.findAll();
		
		
		
		m.addObject("student", list);
		m.setViewName("student_list.jsp");
		return m;
	}
	
	@GetMapping("/viewStudent")
	public ModelAndView m13(ModelAndView m, @RequestParam("name") String name , @RequestParam("email") String email) {
	    Student s = ss.findByName(name);
	    List<Purchase> list = ps.findBookByEmail(email);
	    if (s != null) {
	    	
	    	
			
			m.addObject("purchase", list);
	    	
	        m.addObject("student", s);
	        m.setViewName("profileAdmin.jsp");  // Correct view name
	    } else {
	        m.addObject("msg", "Student not found!");
	        m.setViewName("error");
	    }
	    return m;
	}

	
	@PostMapping(value = {"/deptList"})
	public ModelAndView m14(ModelAndView m)
	{
		m.addObject("book", bs.findDistinctDepartments());
    	m.addObject("quantity",ds.findQuantity());
		m.setViewName("adminDeptList.jsp");
		return m;
	}

	@GetMapping(value = {"/back1"})
	public ModelAndView m15(ModelAndView m , String back)
	{
			m.setViewName("studentHome.jsp");
		return m;
	}

	
	@GetMapping(value = {"/logout"})
	public ModelAndView m16(ModelAndView m , String logout)
	{
			m.setViewName("index.jsp");
		return m;
	}
	

	@GetMapping(value = {"/users"})
	public ModelAndView m16(ModelAndView m)
	{
		m.setViewName("index.jsp");
		return m;
	}
	
}


