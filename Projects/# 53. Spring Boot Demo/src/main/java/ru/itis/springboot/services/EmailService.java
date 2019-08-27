package ru.itis.springboot.services;

public interface EmailService {
    void sendEmail(String email, String subject, String text);
}
