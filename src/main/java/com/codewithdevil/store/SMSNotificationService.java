package com.codewithdevil.store;

import org.springframework.stereotype.Service;

@Service("sms")
public class SMSNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("SMS Notification Service: " + message);
    }

    @Override
    public void send(String message, String recipientEmail) {
        System.out.println("SMS Notification Service: " + message);
    }
}
