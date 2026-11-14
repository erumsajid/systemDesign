package com.system.design.projects.MovieBookingSystem;

import java.util.List;

public class NotificationService {
    private final List<NotificationStrategy> notificationStrategyList;

    public NotificationService(List<NotificationStrategy> notificationStrategyList) {
        this.notificationStrategyList = notificationStrategyList;
    }

    public void sendNotification(Booking booking){
        for(NotificationStrategy  notificationStrategy: notificationStrategyList){
            notificationStrategy.sendNotification("booking.com",List.of(booking.getUser()),"");
        }

    }
}
