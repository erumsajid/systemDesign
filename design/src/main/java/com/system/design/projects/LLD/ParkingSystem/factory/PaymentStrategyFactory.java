package com.system.design.projects.LLD.ParkingSystem.factory;

import com.system.design.projects.LLD.ParkingSystem.enums.PaymentMode;
import com.system.design.projects.LLD.ParkingSystem.strategy.payment.CardPayment;
import com.system.design.projects.LLD.ParkingSystem.strategy.payment.CashPayment;
import com.system.design.projects.LLD.ParkingSystem.strategy.payment.PaymentStrategy;

public class PaymentStrategyFactory {
    public static PaymentStrategy get(PaymentMode mode) {
        return switch (mode) {
            case CASH -> new CashPayment();
            case UPI -> null;
            case CARD -> new CardPayment();
        };
    }
}
