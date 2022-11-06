package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.impl.BlogService;
import com.example.demo.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class BlogRestController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    BlogService blogService;

    @GetMapping("/listCatrgory")
    public List<Category> categoryList() {
        return categoryService.findAll();
    }

    @GetMapping("/listBlog")
    public Page home(@RequestParam(value = "page", defaultValue = "0") int page
            , @RequestParam(value = "size", defaultValue = "5") int size) {
        Sort sort = Sort.by("name").ascending();
        Page listRecord = blogService.getAll(PageRequest.of(page, size, sort));
        ;
        return listRecord;
    }

    @GetMapping("/findBlogByCategory/{id}")
    public List<Blog> find(@PathVariable Long id) {
        return blogService.findAllByCategory(id);
    }

    @GetMapping("/selectContent/{id}")
    public String selectContent(@PathVariable(name = "id") Long id) {
        return blogService.selectContent(id);
    }
}
