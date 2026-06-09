package com.electricshop.electronics_store.controller;


import org.springframework.ui.Model;
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

    // புதிய பொருளைச் சேர்க்கும் படிவத்தைக் காட்ட
    @GetMapping("/add")
    public String showAddForm() {
        return "admin-add-product"; // admin-add-product.html
    }

    // படத்தை அப்லோட் செய்து பொருளைச் சேமிக்க
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product,
                              @RequestParam("file") MultipartFile file) throws IOException {
        productService.saveProduct(product, file);
        return "redirect:/"; // சேமித்த பின் முகப்புப் பக்கத்திற்குச் செல்ல
    }

    // அனைத்துப் பொருட்களையும் காட்ட
    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    // ஒரு பொருளின் விவரங்களைக் காட்ட
    @GetMapping("/product/{id}")
    public String productDetails(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product-details";
    }
}
