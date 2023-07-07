package com.example.contacts_task.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
public class Phone {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    @NotEmpty
    @Pattern(regexp = "^380\\d{9}$", message = "Invalid format. Expected: 380XXXXXXXXX")
    private String number;

    public Phone() {
    }

    public Phone(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


}
