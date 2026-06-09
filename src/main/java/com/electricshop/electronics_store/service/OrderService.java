package com.electricshop.electronics_store.service;


import com.electricshop.electronics_store.model.Order;
import com.electricshop.electronics_store.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public Order createOrder(Order order) {
        // 1. ஆர்டர் நிலையை உறுதி செய்தல்
        order.setStatus("PENDING");

        // 2. மொத்தத் தொகையைக் கணக்கிடுதல்
        if (order.getItems() != null) {
            double total = order.getItems().stream()
                    .mapToDouble(item -> item.getPrice() * item.getQuantity())
                    .sum();
            order.setTotalAmount(total);
        }

        // 3. சேமித்தல்
        return orderRepository.save(order);
    }
}
