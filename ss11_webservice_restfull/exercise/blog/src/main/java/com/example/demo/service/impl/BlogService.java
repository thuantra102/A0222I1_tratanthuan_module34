package com.example.demo.service.impl;

import com.example.demo.model.Blog;
import com.example.demo.repository.BlogRepository;
import com.example.demo.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements ICrudService<Blog> {
    @Autowired
    BlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Page getAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }
    public Page findAllByName(Pageable pageable,String name) {return  blogRepository.findAllByNameContaining(pageable,name);}
    public List<Blog> findAllByCategory(Long id) {
        return blogRepository.findAllByCategory(id);
    }
    public String selectContent(Long id) {
        return blogRepository.selectContent(id);
    }
}
