package com.controller;

import com.model.Customer;
import com.service.CustomerService;
import com.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @GetMapping("/")
    public ModelAndView listCustomer() {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("listCustomer",customerService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/add");
        modelAndView.addObject("createForm",new Customer());
        return modelAndView;
    }
    @PostMapping("/create/customer")
    public String saveCustomer(@ModelAttribute("createForm") Customer customer) {
        customerService.save(customer);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        if(id == 0) {
            modelAndView.addObject("editForm",new Customer());

        } else  {
            modelAndView.addObject("editForm",customerService.findById(id));
        }

        return modelAndView;
    }
    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute("editForm") Customer customer) {
        customerService.save(customer);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("deleteForm",customerService.findById(id));
        return modelAndView;
    }
    @PostMapping("/delete/customer")
    public String deleteCustomer(@ModelAttribute("deleteForm") Customer customer ) {
        customerService.delete(customer.getId());
        return "redirect:/";
    }




}
