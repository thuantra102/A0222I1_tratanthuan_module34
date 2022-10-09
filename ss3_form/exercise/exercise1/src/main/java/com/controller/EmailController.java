package com.controller;

import com.model.EmailModel;
import com.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {
    @Autowired
    EmailService emailService;
    @GetMapping("")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("createForm", new EmailModel());
        return modelAndView;
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("createForm") EmailModel emailModel){
        emailService.save(emailModel);
        return "redirect:/";


    }
}
