package com.electricshop.electronics_store.service;


import com.electricshop.electronics_store.model.Product;
import com.electricshop.electronics_store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CloudinaryService cloudinaryService;

    // படத்தை அப்லோட் செய்து, பொருளை டேட்டாபேஸில் சேமிக்கும் முறை
    public void saveProduct(Product product, MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            String imageUrl = cloudinaryService.uploadImage(file);
            product.setImageUrl(imageUrl);
        }
        productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
