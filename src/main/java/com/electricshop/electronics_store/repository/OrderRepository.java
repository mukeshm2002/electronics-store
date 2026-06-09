package com.electricshop.electronics_store.repository;


import com.electricshop.electronics_store.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // ஒரு குறிப்பிட்ட வாடிக்கையாளரின் ஆர்டர்களை மட்டும் எடுக்க
    List<Order> findByCustomerId(Long customerId);

    // ஸ்டேட்டஸ் அடிப்படையில் ஆர்டர்களை எடுக்க (Pending, Delivered, etc.)
    List<Order> findByStatus(String status);
}
