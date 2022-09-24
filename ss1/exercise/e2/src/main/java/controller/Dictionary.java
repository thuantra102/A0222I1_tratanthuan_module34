package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Dictionary {
    public static Map<String,String> dictionary = new HashMap<>();
    static {
        dictionary.put("hello","xin chao");
        dictionary.put("morning","chao buoi sang");
        dictionary.put("dog","cho");
    }
    @GetMapping(value = "/translate")
    public String translate(@RequestParam String e,Model model) {
        model.addAttribute("vn",dictionary.get(e));
        return "index";
    }
    @GetMapping(value = "")
    public String open() {
        return "index";
    }




}
