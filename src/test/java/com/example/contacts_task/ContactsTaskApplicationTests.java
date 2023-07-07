package com.example.contacts_task;

import com.example.contacts_task.entity.Contact;
import com.example.contacts_task.repository.ContactRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class ContactsTaskApplicationTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    ContactRepository contactRepository;

    @Test
    public void createContact_Test(){
        Contact contact = new Contact();
        contact.setName("Test");
        contactRepository.save(contact);
        Long id= contact.getId();

        Contact found = contactRepository.findById(id).orElse(null);

        assertNotNull(found);
        assertEquals(contact.getName(), found.getName());
        assertEquals(contact.getEmails(), found.getEmails());
        assertEquals(contact.getPhones(), found.getPhones());

    }

    @Test
    public void deleteContact_Test(){
        Contact contact = new Contact();
        contact.setName("Test");
        contactRepository.save(contact);
        Long id= contact.getId();
        contactRepository.deleteById(id);
        Contact found = contactRepository.findById(id).orElse(null);

        assertNull(found);

    }

    @Test
    public void editContact_Test(){
        Contact contact = new Contact();
        contact.setName("Test");
        contactRepository.save(contact);
        Long id= contact.getId();

        Contact found = contactRepository.findById(id).get();

        found.setName("Changed");
        Contact result = contactRepository.save(found);
        assertNotEquals("Test", result.getName());
    }
    


}
