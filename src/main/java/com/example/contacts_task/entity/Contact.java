package com.example.contacts_task.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false)
    @NotEmpty
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Email> emails = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Phone> phones = new ArrayList<>();

    public Contact() {
    }

    public Contact(Long id, String name, List<Email> emails, List<Phone> phones) {
        this.id = id;
        this.name = name;
        this.emails = emails;
        this.phones = phones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

}
