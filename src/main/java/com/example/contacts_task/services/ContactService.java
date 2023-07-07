package com.example.contacts_task.services;

import com.example.contacts_task.entity.Contact;
import com.example.contacts_task.repository.ContactRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Transactional
    public Contact createContact(Contact contact){
        String name = contact.getName();
        if (contactRepository.findContactByName(name) != null){
            return  contact;
        }
        return contactRepository.save(contact);
    }

    @Transactional(readOnly = true)
    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }

    @Transactional
    public Contact updateContact(Contact contact){
        Contact existingContact = contactRepository.findById(contact.getId()).get();
        existingContact.setName(contact.getName());
        existingContact.setEmails(contact.getEmails());
        existingContact.setPhones(contact.getPhones());
        return contactRepository.save(existingContact);
    }

    @Transactional
    public void deleteContact(Long contactId){
        contactRepository.deleteById(contactId);
    }




}
