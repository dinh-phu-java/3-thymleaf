package com.dinhphu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class MainController {
    @RequestMapping("/")
    public String home(){
        return "index";
    }
}
