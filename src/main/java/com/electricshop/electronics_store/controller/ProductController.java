package com.electricshop.electronics_store.controller;

import com.electricshop.electronics_store.model.Product;
import com.electricshop.electronics_store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Controller
@RequestMapping("/admin/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/add")
    public String showAddForm() {
        return "admin-add-product";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product,
                              @RequestParam("file") MultipartFile file) throws IOException {
        productService.saveProduct(product, file);
        return "redirect:/admin/products/products"; // Redirect to admin product list
    }
}