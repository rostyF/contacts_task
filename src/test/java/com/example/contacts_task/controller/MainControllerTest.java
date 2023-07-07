package com.example.contacts_task.controller;

import com.example.contacts_task.controllers.MainController;
import com.example.contacts_task.entity.Contact;
import com.example.contacts_task.entity.Email;
import com.example.contacts_task.entity.Phone;
import com.example.contacts_task.services.ContactService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MainController mainController;

    @Autowired
    private ContactService contactService;

    @Test
    public void connectionTest() throws Exception {
        Contact contact = new Contact();
        contact.setName("Peter");

        List<Email> emails = contact.getEmails();
        emails.add(new Email("sample@gmail.com"));
        contact.setEmails(emails);

        List<Phone> phones = contact.getPhones();
        phones.add(new Phone("380981234567"));
        contact.setPhones(phones);

        contactService.createContact(contact);

        mockMvc.perform(get("/contacts"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value(contact.getName()));


    }


}
