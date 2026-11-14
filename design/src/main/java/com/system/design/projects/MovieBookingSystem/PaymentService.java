package com.system.design.projects.MovieBookingSystem;

import java.util.Map;

public class PaymentService {
    private final Map<String,PaymentStrategy> paymentStrategy;

    public PaymentService(Map<String,PaymentStrategy> paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    public Payment processPayment(String type,Payment payment){
        PaymentStrategy paymentStrategy1 = paymentStrategy.get(type);
        paymentStrategy1.processPayment();
        return payment;
    }
}
