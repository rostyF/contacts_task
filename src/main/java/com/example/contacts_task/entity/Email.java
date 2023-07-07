package com.example.contacts_task.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Email {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    @NotEmpty
    @jakarta.validation.constraints.Email
    private String email;


    public Email() {
    }

    public Email(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
