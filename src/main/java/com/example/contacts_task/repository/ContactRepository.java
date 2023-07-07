package com.example.contacts_task.repository;

import com.example.contacts_task.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    Contact findContactByName(String name);
}
