package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerServiceImp;
import com.codegym.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    private ICustomerService customerService=new CustomerServiceImp();

    @GetMapping("/")
    public String index(Model model){
        List customerList = customerService.findAll();

        model.addAttribute("customers",customerList);
        return "index";
    }
    @GetMapping("/customer/create")
    public String createCustomer(Model theModel){
        theModel.addAttribute("customer",new Customer());
        return "/create";
    }

    @PostMapping("/customer/save")
    public String save(Customer customer, RedirectAttributes redirect){
        return "";
    }
}
