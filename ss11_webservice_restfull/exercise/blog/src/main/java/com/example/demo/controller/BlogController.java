package com.example.demo.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.model.AppUser;
import com.example.demo.model.Blog;
import com.example.demo.service.impl.BlogService;
import com.example.demo.service.impl.CategoryService;
import com.example.demo.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.security.Principal;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Map;

@Controller
public class BlogController {
    @Autowired
    Cloudinary cloudinary;
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    Timestamp date = new Timestamp(System.currentTimeMillis());

    @GetMapping(value = "/list")
    public String home(Model model, @RequestParam(value = "page", defaultValue = "0") int page
            , @RequestParam(value = "size", defaultValue = "5") int size, @RequestParam(value = "nameSearch",defaultValue = "") String name,
                       Principal principal ) {
        Sort sort =Sort.by("name").ascending();
        Page listRecord;
        if(!name.equals("")) {
            listRecord = blogService.findAllByName(PageRequest.of(page,size,sort),name);
        } else  {
            listRecord = blogService.getAll(PageRequest.of(page, size,sort));
        }
        model.addAttribute("listBlog",listRecord );
        model.addAttribute("listCategory", categoryService.findAll());
        model.addAttribute("form", new Blog());
        model.addAttribute("size", size);
        model.addAttribute("presentRecord",listRecord.getNumberOfElements());
        model.addAttribute("nameSearch", name);
        model.addAttribute("userInfo", principal == null ? "Anonymous" : principal.getName());


//        model.addAttribute("typeSort","/sort?type=ASC");
        return "list";
    }
    @GetMapping("/register")
    public String home(Model model) {
        model.addAttribute("user", new AppUser());
        return "register";
    }
    @PostMapping("/registerUser")
    public String user(@ModelAttribute("user") AppUser user,Model model) {
        user.setEncrytedPassword(bCryptPasswordEncoder.encode(user.getEncrytedPassword()));
        user.setEnabled(true);
        userDetailsService.saveUser(user);
        model.addAttribute("user", new AppUser());
        return "/register";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "login";
    }
    @GetMapping("/logoutSuccessful")
    public String logOutPage() {
        return "redirect:/";
    }


    @PostMapping("/save")
    public String save(@ModelAttribute("form") Blog blog) throws IOException {
        blog.setDateUpload(formatter.format(date));
        Map u = cloudinary.uploader().upload(blog.getImageUpload().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
        blog.setUrlImage((String) u.get("secure_url"));
        blogService.save(blog);
        return "redirect:/list";
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Blog getBlogById(@PathVariable Long id) {
        return blogService.findById(id);
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(name = "deleteId") Long id) {
        blogService.delete(blogService.findById(id));
        return "redirect:/list";
    }
//    @GetMapping("/sort")
//    public String sort(Model model, @RequestParam String type, RedirectAttributes redirectAttributes) {
//        if(type.equals("ASC") || type == null) {
//            redirectAttributes.addFlashAttribute("typeSort","/sort?type=ASC");
//        } else  {
//            redirectAttributes.addFlashAttribute("typeSort","/sort?type=DCS");
//        }
//        return "redirect:/";
//    }
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public String ex() {
        return "ex";
    }

}
