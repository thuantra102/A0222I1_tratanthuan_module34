package com.spring.controller;

import com.spring.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @GetMapping("show")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "create";
    }

    @PostMapping("create")
    public String submit(@ModelAttribute("employee") Employee employee, Model model) {
        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());
        model.addAttribute("id", employee.getId());
        return "info";
    }
    @GetMapping("")
    public String open() {
        return "index";
    }

}
