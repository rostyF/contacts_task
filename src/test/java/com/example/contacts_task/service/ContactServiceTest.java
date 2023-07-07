package com.example.contacts_task.service;

import com.example.contacts_task.entity.Contact;
import com.example.contacts_task.entity.Email;
import com.example.contacts_task.entity.Phone;
import com.example.contacts_task.repository.ContactRepository;
import com.example.contacts_task.services.ContactService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactServiceTest {
    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    private ContactService contactService;

    @Test
    public void saveContact_shouldCallRepository(){
        Contact contact = new Contact();
        contact.setName("Peter");

        List<Email> emails = contact.getEmails();
        emails.add(new Email("sample@gmail.com"));
        contact.setEmails(emails);

        List<Phone> phones = contact.getPhones();
        phones.add(new Phone("380981234567"));
        contact.setPhones(phones);

        contactService.createContact(contact);

        verify(contactRepository).save(contact);
    }






}
