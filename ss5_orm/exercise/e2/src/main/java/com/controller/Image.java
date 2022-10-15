package com.controller;

import com.model.ImageModel;
import com.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Image {
    @Autowired
    ImageService imageService;

    @GetMapping()
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("/image");
        modelAndView.addObject("form", new ImageModel());
        return modelAndView;
    }
    @PostMapping("/add")
    public String add(@ModelAttribute("form") ImageModel image, RedirectAttributes redirectAttributes) {
        imageService.save(image);
        redirectAttributes.addFlashAttribute("urlImage",image.getUrlImage());
        redirectAttributes.addFlashAttribute("list",imageService.findById(image.getIdImage()));
        return "redirect:/";
    }
}
