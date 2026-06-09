package com.electricshop.electronics_store.controller;


import com.electricshop.electronics_store.model.Order;
import com.electricshop.electronics_store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // ஆர்டர் செய்யும் பக்கத்தைக் காட்ட
    @GetMapping("/checkout")
    public String showCheckout() {
        return "checkout";
    }

    // ஆர்டரைச் சமர்ப்பிக்க
    @PostMapping("/submit")
    public String submitOrder(@ModelAttribute Order order) {
        orderService.createOrder(order);
        return "redirect:/orders/success";
    }

    @GetMapping("/success")
    public String orderSuccess() {
        return "order-success";
    }
}
