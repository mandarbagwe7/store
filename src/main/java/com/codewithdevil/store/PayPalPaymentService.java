package com.codewithdevil.store;

public class PayPalPaymentService implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("PayPal Payment Service");
        System.out.println("Amount: " + amount);
    }
}
