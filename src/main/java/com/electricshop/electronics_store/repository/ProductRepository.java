package com.electricshop.electronics_store.repository;

import com.electricshop.electronics_store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // பெயர் வைத்து தேட உதவும் மெத்தட்
    List<Product> findByNameContainingIgnoreCase(String name);

    // குறிப்பிட்ட வகையின் கீழ் உள்ள பொருட்களை எடுக்க
    List<Product> findByCategoryId(Long categoryId);
}
