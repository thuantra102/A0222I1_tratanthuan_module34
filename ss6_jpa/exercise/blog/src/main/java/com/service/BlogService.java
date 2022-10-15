package com.service;

import com.model.BlogModel;
import com.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired
    BlogRepository blogRepository;
    @Override
    public List<BlogModel> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public List<BlogModel> findByName(String name) {
        return null;
    }

    @Override
    public void save(BlogModel blogModel) {
        blogRepository.save(blogModel);
    }

    @Override
    public void delete(BlogModel blogModel) {
        blogRepository.delete(blogModel);
    }

    @Override
    public BlogModel findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }


}
