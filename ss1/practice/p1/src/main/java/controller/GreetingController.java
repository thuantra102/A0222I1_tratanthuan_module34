package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting() {
        return "index";
    }
    @GetMapping("")
    public String greeting1() {
        return "index";
    }
}
