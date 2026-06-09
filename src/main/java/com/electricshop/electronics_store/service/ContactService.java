package com.electricshop.electronics_store.service;


import com.electricshop.electronics_store.model.Contact;
import com.electricshop.electronics_store.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public void saveInquiry(Contact contact) {
        contactRepository.save(contact);
    }

    public List<Contact> getAllInquiries() {
        return contactRepository.findAll();
    }
}
