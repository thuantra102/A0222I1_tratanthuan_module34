package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Calculator {
    @PostMapping("/save")
    public String add(@RequestParam int a,@RequestParam int b,@RequestParam String button,Model model) {
       if(button.equalsIgnoreCase("add")) {
           model.addAttribute("result",a +b);
       }else if(button.equalsIgnoreCase("sub")) {
           model.addAttribute("result",a -b);
       }else if(button.equalsIgnoreCase("multi")) {
           model.addAttribute("result",a * b);
       }else {
           model.addAttribute("result",a /b);
       }
        return "index";
    }
    @GetMapping(value = "")
    public String open() {
        return "index";
    }
}
