package com.system.design.projects.MovieBookingSystem;

public class UPIPaymentStrategy implements PaymentStrategy{
    @Override
    public int processPayment() {
        System.out.println("Payment is initiated by UPI");
        return 0;
    }
}
