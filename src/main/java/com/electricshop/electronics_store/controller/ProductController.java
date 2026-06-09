package com.electricshop.electronics_store.controller;

import com.electricshop.electronics_store.model.Product;
import com.electricshop.electronics_store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Controller
@RequestMapping("/admin/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // This will now correctly map to /admin/products/add
    @GetMapping("/add")
    public String showAddForm() {
        return "admin-add-product";
    }

    // This will now correctly map to /admin/products/save
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product,
                              @RequestParam("file") MultipartFile file) throws IOException {
        productService.saveProduct(product, file);
        return "redirect:/admin/products/products";
    }

    // THIS IS THE KEY CHANGE:
    // Use an empty path "" or just "/products" depending on your preference.
    // If you want the URL to be /admin/products/products, define it as below:
    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products"; // Refers to products.html
    }
}