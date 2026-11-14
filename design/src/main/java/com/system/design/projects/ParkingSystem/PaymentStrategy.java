package com.system.design.projects.ParkingSystem;

public interface PaymentStrategy {
    boolean initiatePayment(double amount);
}
