package com.electricshop.electronics_store.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Double price;

    private Integer stockQuantity;

    private String imageUrl; // Cloudinary URL இங்கே சேமிக்கப்படும்

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
