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
        // ஆர்டர் செய்யும் போது மொத்தத் தொகை மற்றும் ஸ்டேட்டஸை உறுதி செய்தல்
        order.setStatus("PENDING");
        return orderRepository.save(order);
    }
}
