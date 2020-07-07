package com.dinhphu.controller;

import com.dinhphu.model.Employee;
import com.dinhphu.services.employee.IEmployeeServices;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class MainController {
    @Autowired
    private IEmployeeServices employeeServices;

    @RequestMapping("/")
    public String home(Model theModel){

        ArrayList<Employee> list=new ArrayList<>(employeeServices.findAll()) ;

        list.forEach(k-> System.out.println(k));
        theModel.addAttribute("list",list);
        return "index";
    }

    @GetMapping("/employee/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id){
        ModelAndView modelAndView= new ModelAndView("edit");
        Employee editEmp=employeeServices.findById(id);
        System.out.println(editEmp);
        modelAndView.addObject("editEmp",editEmp);
        return modelAndView;
    }

    @PostMapping("/employee/edit/{id}")
    public ModelAndView editProcess(@ModelAttribute Employee editEmp){
        ModelAndView modelAndView=new ModelAndView("edit");
        System.out.println(editEmp);
        System.out.println(editEmp.getFirstName());
        return modelAndView;
    }
}
