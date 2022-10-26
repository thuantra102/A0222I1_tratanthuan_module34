package com.example.demo.controller;

import com.example.demo.model.Music;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.Valid;

@Controller
public class MusicController {
    @GetMapping
    public String home(Model model) {
        model.addAttribute("formMusic",new Music());
        return "form";
    }
    @GetMapping("/valid")
    public String check(@Valid @ModelAttribute("formMusic") Music music, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "form";
        }
        return "redirect:/";
    }
}
