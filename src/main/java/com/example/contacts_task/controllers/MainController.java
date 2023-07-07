package com.example.contacts_task.controllers;

import com.example.contacts_task.entity.Contact;
import com.example.contacts_task.services.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contacts")
public class MainController {
    private ContactService contactService;

    public MainController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact){
        Contact saved = contactService.createContact(contact);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts(){
        List<Contact> contacts = contactService.getAllContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable("id") Long contactId,
                                                    @RequestBody Contact contact){
        contact.setId(contactId);
        Contact updated = contactService.updateContact(contact);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteContact(@PathVariable("id") Long contactId){
        contactService.deleteContact(contactId);
        return new ResponseEntity<>("Contact succesfully deleted!", HttpStatus.OK);
    }
}
