package com.system.design.projects.LLD.ParkingSystem.model;

import com.system.design.projects.ParkingSystem.PaymentStatus;
import com.system.design.projects.ParkingSystem.PaymentStrategy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket {
    int ticketNo;
    String parkingSlotId;
    String floorId;
    String customerId;
    Vehicle vehicle;
    PaymentStatus paymentStatus;
    PaymentStrategy paymentStrategy;
    long entryTime;
    long exitTime;
}
