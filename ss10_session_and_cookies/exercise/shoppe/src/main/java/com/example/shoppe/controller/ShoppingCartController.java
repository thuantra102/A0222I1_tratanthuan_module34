package com.example.shoppe.controller;

import com.example.shoppe.model.Cart;
import com.example.shoppe.model.Product;
import com.example.shoppe.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class ShoppingCartController {
    @Autowired
    ProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart(@SessionAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Long id, @SessionAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("detail");
        Product product = productService.findById(id).get();
        Product product1 = null;
        for (Map.Entry<Product,Integer> entry: cart.getProducts().entrySet()) {
            if(entry.getKey().getId().equals(product.getId())) {
                product1 = entry.getKey();
                break;
            }
        }
        modelAndView.addObject("product", product1);
        return modelAndView;
    }
}