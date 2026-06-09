package com.electricshop.electronics_store.repository;

import com.electricshop.electronics_store.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    // தேதியின் அடிப்படையில் மெசேஜ்களை வரிசைப்படுத்தலாம் (தேவைப்பட்டால்)
}
