package com.system.design.projects.ParkingSystem;

public class UPIPayment implements PaymentStrategy{
    @Override
    public boolean initiatePayment(double amount) {
        System.out.println("Initiated UPI Payment " + amount);
        return true;
    }
}
