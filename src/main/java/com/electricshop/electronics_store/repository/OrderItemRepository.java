package com.electricshop.electronics_store.repository;

import com.electricshop.electronics_store.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    // ஒரு ஆர்டரில் உள்ள அனைத்து பொருட்களையும் எடுக்க
    List<OrderItem> findByOrderId(Long orderId);
}
