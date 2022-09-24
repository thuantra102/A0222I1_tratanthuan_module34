package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculate {
    @GetMapping(value = "/calculate")
    public String getResult(@RequestParam(name = "usd") Integer usd, Model model) {
        float result = usd * 23000;
        model.addAttribute("result",result);
        return "index";
    }
    @GetMapping(value = "")
    public String getResult1() {
        return "index";
    }


}
