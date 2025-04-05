package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Department;
import com.demo.service.DepartmentService;

@Controller
public class DepartmentController {
    @Autowired
    DepartmentService ds;

    @GetMapping(value = {"/addDept"})
    public ModelAndView d1(ModelAndView m, String dept_name,String deptAdd) {

        Department d1 = ds.findByDepartment(dept_name);

        if (d1 == null) {

            d1 = new Department();
            d1.setBook_dept(dept_name);
      

            ds.save(d1); 
            m.addObject("msg", "Department added successfully!");
        } else {
            m.addObject("msg", "Department is already added!");
        }

        m.setViewName("dept_add.jsp");
        return m;
    }

}

/*

				else
				{
					m.addObject("msg", "not added please try again !!!!");
					m.setViewName("dept_add.jsp");
				}

*/