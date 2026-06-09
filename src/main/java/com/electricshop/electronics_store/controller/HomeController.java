package com.electricshop.electronics_store.controller;


import com.electricshop.electronics_store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String index(Model model) {
        // முகப்புப் பக்கத்தில் எல்லாப் பொருட்களையும் காட்ட
        model.addAttribute("products", productService.getAllProducts());
        return "index"; // index.html பக்கத்தை காட்டும்
    }
}
