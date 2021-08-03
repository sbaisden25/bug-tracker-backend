package com.example.bugtracker.email;

public interface EmailSender {
    void send(String to, String email);
}