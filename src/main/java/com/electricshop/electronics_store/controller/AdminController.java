package com.electricshop.electronics_store.controller;


import com.electricshop.electronics_store.repository.OrderRepository;
import com.electricshop.electronics_store.service.OrderService;
import com.electricshop.electronics_store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;


    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("orders", orderRepository.findAll()); // அனைத்து ஆர்டர்களையும் எடுக்க
        return "admin-dashboard";
    }
}
