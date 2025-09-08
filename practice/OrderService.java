package com.codewithdevil.store;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class OrderService {

    private PaymentService paymentService;

//    public OrderService(
//           @Qualifier("stripe") PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("Order Service Created");
    }

    @PostConstruct
    public void init(){
        System.out.println("Order Service PostConstruct");
    }

    @PostConstruct
    public void init2(){
        System.out.println("Order Service PostConstruct 2");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Order Service PreDestroy");
    }

    @PreDestroy
    public void destroy2(){
        System.out.println("Order Service PreDestroy 2");
    }

    public void placeOrder() {
        paymentService.processPayment(10);
    }
}
