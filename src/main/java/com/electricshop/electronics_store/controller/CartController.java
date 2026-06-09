package com.electricshop.electronics_store.controller;


import com.electricshop.electronics_store.model.Product;
import com.electricshop.electronics_store.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String showCart(HttpSession session, Model model) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        model.addAttribute("cartItems", cart != null ? cart : new ArrayList<>());
        return "cart";
    }

    @PostMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, HttpSession session) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();

        cart.add(productService.getProductById(id));
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }
}
