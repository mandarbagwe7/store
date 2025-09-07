package com.codewithdevil.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("email")
@Primary
public class EmailNotificationService implements NotificationService {

    @Value("${email.host}")
    String host;

    @Value("${email.port}")
    int port;

    @Override
    public void send(String message) {
        System.out.println("Email Notification Service: " + message);
    }

    @Override
    public void send(String message, String recipientEmail) {
        System.out.println("Host: " + host);
        System.out.println("Port: " + port);
        System.out.println("Sending Email: " + message + " - to " + recipientEmail);
    }
}
