package com.codewithdevil.store;

public interface NotificationService {
    void send(String message);
    void send(String message, String recipientEmail);
}
