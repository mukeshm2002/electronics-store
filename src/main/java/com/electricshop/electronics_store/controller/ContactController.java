package com.electricshop.electronics_store.controller;


import com.electricshop.electronics_store.model.Contact;
import com.electricshop.electronics_store.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public String showContactForm() {
        return "contact"; // contact.html பக்கத்தைக் காட்டும்
    }

    @PostMapping("/submit")
    public String submitInquiry(@ModelAttribute Contact contact) {
        contactService.saveInquiry(contact);
        return "redirect:/contact?success";
    }
}
