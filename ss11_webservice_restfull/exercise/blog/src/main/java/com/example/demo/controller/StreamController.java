package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.impl.BlogStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/testStream")
public class StreamController {
    @Autowired
    BlogStreamService blogStreamService;
    @GetMapping("/getAll")
    public List<Blog> getAll() {
        return blogStreamService.getBlogs();
    }

}
