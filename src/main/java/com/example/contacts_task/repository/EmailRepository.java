package com.example.contacts_task.repository;

import com.example.contacts_task.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
