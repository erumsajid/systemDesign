package com.system.design.projects.MovieBookingSystem;

import java.util.List;

public interface NotificationStrategy {
    boolean sendNotification(String senderAddress, List<String> receiverAddress, String body);
}
