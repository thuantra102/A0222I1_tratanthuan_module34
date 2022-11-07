package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.impl.BlogService;
import com.example.demo.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:5500/")
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
    public ResponseEntity<Page> home(@RequestParam(value = "page", defaultValue = "0") int page
            , @RequestParam(value = "size", defaultValue = "5") int size
                ,@RequestParam(value = "nameSearch",defaultValue = "") String name) {
        Sort sort = Sort.by("name").ascending();
        Page listRecord;
        if(!name.equals("")) {
            listRecord = blogService.findAllByName(PageRequest.of(page,size,sort),name);
        } else  {
            listRecord = blogService.getAll(PageRequest.of(page, size,sort));
        }

        if(listRecord.getContent().size() <= 0) {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(listRecord, HttpStatus.OK);
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
