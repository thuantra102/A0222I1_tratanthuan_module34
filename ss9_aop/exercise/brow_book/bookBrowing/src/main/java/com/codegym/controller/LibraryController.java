package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.Code;
import com.codegym.model.Status;
import com.codegym.service.impl.BookService;
import com.codegym.service.impl.CodeService;
import com.codegym.util.exeption.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LibraryController {
    @Autowired
    CodeService codeService;
    @Autowired
    BookService bookService;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("list", bookService.findAll());
        return "home";
    }

    @GetMapping("/addBook")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("form", new Book());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("form") Book book) {
        bookService.save(book);
        return "redirect:/";
    }

    @GetMapping("/borrow/{id}")
    public String borrow(@PathVariable Long id, Model model) {
        model.addAttribute("info", bookService.findById(id));
        return "borrow";
    }

    @PostMapping("/borrowBook")
    public String borrowBook(@RequestParam Integer quantity, @RequestParam Long id, Model model) throws Exception {
        Integer quantityOfBook = bookService.findById(id).getQuantity();
        List<Code> codeList;
        if (quantity > quantityOfBook) {
            throw new MyException("error");
        } else {
            codeList = codeService.getAllByBookId(id, quantity);
            model.addAttribute("borrowInfo", codeList);
            for (Code c : codeList) {
                c.setStatus(new Status(1L));
                codeService.save(c);
            }
           Book editBook =  bookService.findById(id);
            editBook.setQuantity(quantityOfBook - quantity);
            bookService.save(editBook);

        }
        return "info";
    }

    @ExceptionHandler(MyException.class)
    public String handle() {
        return "error";
    }


}
