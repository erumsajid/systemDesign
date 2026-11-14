package com.system.design.projects.LLD.ParkingSystem.strategy.payment;


import java.util.Random;

public class CardPayment implements PaymentStrategy {
    @Override
    public long initiatePayment(double amount){
        Random random = new Random();
        return random.nextLong();
    }
}
