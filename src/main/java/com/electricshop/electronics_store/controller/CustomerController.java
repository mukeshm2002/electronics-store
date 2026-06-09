package com.electricshop.electronics_store.controller;

import com.electricshop.electronics_store.model.Customer;
import com.electricshop.electronics_store.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Customer customer) {
        customerService.registerCustomer(customer);
        return "redirect:/customer/login";
    }
}
