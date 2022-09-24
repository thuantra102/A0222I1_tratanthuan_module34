package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Calculator {
    @GetMapping(value = "add/{a}/{b}")
    public String add(@PathVariable int a, @PathVariable int b, Model model) {
        model.addAttribute("result",a+b);
        return "index";
    }
    @GetMapping(value = "")
    public String open() {
        return "index";
    }
}
