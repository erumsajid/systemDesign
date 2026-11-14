package com.system.design.projects.MovieBookingSystem;

public class PaymentFactory {
    PaymentStrategy getPaymentStrategy(String type){
        return new UPIPaymentStrategy();
    }
}
