package com.example.formregister.controller;

import com.example.formregister.model.Register;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {
    @GetMapping()
    public String registerForm(Model model) {
        model.addAttribute("registerForm" , new Register());
        return "register";
    }
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("registerForm") Register register, BindingResult bindingResult) {
       new Register().validate(register,bindingResult);
        if(bindingResult.hasErrors()) {
            return "register";
        }
        return "redirect:/";
    }
}
