package com.system.design.projects.LLD.ParkingSystem.service;

import com.system.design.projects.LLD.ParkingSystem.enums.PaymentMode;
import com.system.design.projects.LLD.ParkingSystem.enums.PricingStrategyType;
import com.system.design.projects.LLD.ParkingSystem.factory.PaymentStrategyFactory;
import com.system.design.projects.LLD.ParkingSystem.factory.PricingStrategyFactory;
import com.system.design.projects.LLD.ParkingSystem.model.*;
import com.system.design.projects.LLD.ParkingSystem.strategy.payment.PaymentStrategy;
import com.system.design.projects.LLD.ParkingSystem.strategy.pricing.PricingStrategy;
import com.system.design.projects.ParkingSystem.PaymentStatus;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class ParkingLot {
    private int parkingId;
    private static ParkingLot instance;
    private Map<String, ParkingFloor> parkingFloors = new HashMap<>();
    private final Map<Integer, Ticket> activeTickets = new HashMap<>();

    public void addParkingFloor(ParkingFloor parkingFloor){
        parkingFloors.put(parkingFloor.getId(),parkingFloor);
    }
    public void removeParkingFloor(String  parkingFloorId){
        parkingFloors.remove(parkingFloorId);
    }
    public static ParkingLot getInstance(){
        if(instance==null){
            return new ParkingLot();
        }
        return instance;
    }

    public Ticket parkVehicle(long entryTime, Customer customer){
        ParkingSpot spot = null;
        for(ParkingFloor floor : parkingFloors.values()){
            spot = floor.findAvailableSpot(customer.getVehicle().getType());
            if(spot!=null){
                spot.setParkedVehicle(customer.getVehicle());
                Ticket ticket = new Ticket();
                Random random = new Random();
                ticket.setTicketNo(random.nextInt());
                ticket.setVehicle(customer.getVehicle());
                ticket.setCustomerId(customer.getGovId());
                ticket.setParkingSlotId(spot.getId());
                ticket.setEntryTime(entryTime);
                ticket.setFloorId(floor.getId());
                ticket.setPaymentStatus(PaymentStatus.COMPLETED);
                activeTickets.put(ticket.getTicketNo(),ticket);
                System.out.println("Parking is booked for -"+ customer.getName());
                return ticket;
            }
        }

        System.out.println("no parking space available for customer - "+ customer.getName());
        return null;

    }

    public void unParkVehicle(int ticketNo, PaymentMode paymentMode, long exitTime){
        Ticket ticket = activeTickets.get(ticketNo);
        if(ticket==null){
            throw new RuntimeException("invalid ticket");
        }
        PricingStrategy pricingStrategy = PricingStrategyFactory.get(PricingStrategyType.TIME_BASED);
        double price = pricingStrategy.calculateFee(ticket.getVehicle().getType(),ticket.getEntryTime(),exitTime);
        PaymentStrategy paymentStrategy = PaymentStrategyFactory.get(paymentMode);
        paymentStrategy.initiatePayment(price);
        ticket.setPaymentStatus(PaymentStatus.COMPLETED);
        ParkingSpot spot = parkingFloors.get(ticket.getFloorId()).getSpots().get(ticket.getParkingSlotId());
        spot.setParkedVehicle(null);
        spot.vacate();



    }
    public void printStatus() {
        parkingFloors.forEach((floorId, floor) -> {
            System.out.println("Floor: " + floorId);
            floor.getSpots().values().forEach(spot -> {
                System.out.println(" Spot " + spot.getId() + " [" + spot.getAllowedType() + "] - " + (spot.getIsOccupied() ? "Occupied" : "Free"));
            });
        });
    }


}
