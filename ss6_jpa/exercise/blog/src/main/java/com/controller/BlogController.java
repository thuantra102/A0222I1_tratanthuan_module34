package com.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.model.BlogModel;
import com.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Controller
public class BlogController {
    @Autowired
    Cloudinary cloudinary;
    @Autowired
    IBlogService iBlogService;
    @GetMapping()
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("list",iBlogService.findAll());
        return modelAndView;
    }
    @GetMapping("/save/{id}")
    public ModelAndView save(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/save");
        if(id ==0) {
            modelAndView.addObject("form", new BlogModel());
        } else  {
            modelAndView.addObject("form",iBlogService.findById(id));
        }

        return modelAndView;
    }
    @PostMapping("/save/blog")
    public String saveBlog(@ModelAttribute("form") BlogModel blogModel) throws IOException {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Timestamp date = new Timestamp(System.currentTimeMillis());
        String dateString = formatter.format(date);
        blogModel.setDateUpload(dateString);
        Map u = cloudinary.uploader().upload(blogModel.getImageUpload().getBytes(), ObjectUtils.asMap("resource_type","auto"));
        blogModel.setUrlImage((String) u.get("secure_url"));
        iBlogService.save(blogModel);
        return "redirect:/";
    }
    @GetMapping("/blog/{id}")
    public ModelAndView show(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/show");
        modelAndView.addObject("blog",iBlogService.findById(id));
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        BlogModel blogModel = iBlogService.findById(id);
        iBlogService.delete(blogModel);
        return "redirect:/";
    }
}
