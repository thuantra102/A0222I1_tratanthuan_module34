package com.example.demo.service.impl;

import com.example.demo.model.Blog;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogStreamService {
   @Autowired
   JPAStreamer jpaStreamer;
    public List<Blog> getBlogs() {


        return jpaStreamer.stream(Blog.class)

//                .filter(blog -> blog.getName().contains("s"))
                .sorted(Comparator.comparing(Blog::getName).thenComparing(Blog::getContent))
                .skip(1)
                .limit(9)
                .collect(Collectors.toList());
    }


}
