package com.system.design.projects.LLD.ParkingSystem.service;

import com.system.design.projects.LLD.ParkingSystem.model.Ticket;
import com.system.design.projects.ParkingSystem.PaymentStatus;
import com.system.design.projects.ParkingSystem.PaymentStrategy;

public class PaymentProcessor {
    private final PaymentStrategy paymentStrategy;

    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    public boolean initiatePayment(double amount, Ticket ticket){
        paymentStrategy.initiatePayment(amount);
        ticket.setPaymentStatus(PaymentStatus.COMPLETED);
        return true;
    }
}
