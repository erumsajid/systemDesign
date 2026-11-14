package com.system.design.projects.MovieBookingSystem;

import java.util.List;

public class PaymentNotification implements NotificationStrategy {

    @Override
    public boolean sendNotification(String senderAddress, List<String> receiverAddress, String body) {
        return false;
    }
}
