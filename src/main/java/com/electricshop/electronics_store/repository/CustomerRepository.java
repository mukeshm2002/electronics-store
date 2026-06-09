package com.electricshop.electronics_store.repository;


import com.electricshop.electronics_store.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // மின்னஞ்சல் வைத்து தேட
    Optional<Customer> findByEmail(String email);
}
