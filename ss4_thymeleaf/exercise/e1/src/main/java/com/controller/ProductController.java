package com.controller;

import com.model.Product;
import com.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    IProductService productService;
    @GetMapping()
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject(" list",productService.findAll());
        modelAndView.addObject("form",new Product());
        return modelAndView;
    }
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Product getProduct(@PathVariable Long id) {
        Product product = productService.findById(id).get();
        System.out.println(product.toString());
        return product;
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("form") Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addAttribute("mess","Save successfully");
        return "redirect:/";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        Product product = productService.findById(id).get();
        productService.delete(product);
        return "redirect:/";
    }
    @GetMapping("/search/{name}")
    public ModelAndView search(@PathVariable String name) {
        List<Product> products = productService.findByName(name);
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("list",products);
        return modelAndView;
    }
    public String showList(Model model,List<Product> products) {
        model.addAttribute("list",products);
        return "/list";
    }

}
