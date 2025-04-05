package com.demo.controller;

import com.demo.model.Purchase;
import com.demo.model.Student;
import com.demo.service.PurchaseService;
import com.demo.service.StudentService;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/studentlogin")
    public ModelAndView loginPage() {
        return new ModelAndView("studentlogin");
    }

    @PostMapping("/logincheckstudent")
    public ModelAndView loginCheck(@RequestParam String email,
                                   @RequestParam String password,
                                   HttpSession session) {
        Student student = studentService.login(email, password);
        if (student != null) {
            session.setAttribute("email", email);
            session.setAttribute("password", password);
            return new ModelAndView("redirect:/studentafterlogin");
        } else {
            ModelAndView mv = new ModelAndView("studentlogin");
            mv.addObject("msg", "Invalid Email or Password");
            return mv;
        }
    }

    @GetMapping("/studentafterlogin")
    public ModelAndView afterLogin(HttpSession session) {
        String email = (String) session.getAttribute("email");
        String password = (String) session.getAttribute("password");

        if (email == null || password == null) {
            return new ModelAndView("redirect:/studentlogin");
        }

        List<Purchase> purchases = purchaseService.findByEmailAndPassword(email, password);
        ModelAndView mv = new ModelAndView("studentafterlogin");
        mv.addObject("purchaselist", purchases);
        return mv;
    }

    @GetMapping("/logoutstudent")
    public ModelAndView logoutStudent(HttpSession session) {
        session.invalidate();
        return new ModelAndView("redirect:/studentlogin");
    }
}
