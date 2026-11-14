package com.system.design.projects.LLD.ParkingSystem;

import com.system.design.projects.LLD.ParkingSystem.enums.VehicleType;
import com.system.design.projects.LLD.ParkingSystem.factory.BikeAbstractFactory;
import com.system.design.projects.LLD.ParkingSystem.model.*;
import com.system.design.projects.LLD.ParkingSystem.service.ParkingLot;

public class ParkingSystem {
    public static void main(String[] args) throws InterruptedException {
        ParkingLot lot = ParkingLot.getInstance();
        EntryGate entryGate = new EntryGate();
        ExitGate exitGate = new ExitGate();


        ParkingFloor floor1 = new ParkingFloor("Floor1");
        floor1.addSpot(new ParkingSpot("F1S1", VehicleType.BIKE));
        floor1.addSpot(new ParkingSpot("F1S2", VehicleType.CAR));
        floor1.addSpot(new ParkingSpot("F1S3", VehicleType.TRUCK));
        floor1.addSpot(new ParkingSpot("F1S4", VehicleType.CAR));
        lot.addParkingFloor(floor1);

        System.out.println("--------------------------");

        Vehicle bike1 = new BikeAbstractFactory().createVehicle();
        Vehicle bike2 = new BikeAbstractFactory().createVehicle();
        Customer customer1 = new Customer();
        customer1.setName("Alice");
        customer1.setGovId("1234");
        customer1.setVehicle(bike1);

        Customer customer2 = new Customer();
        customer2.setName("Max");
        customer2.setGovId("1234");
        customer2.setVehicle(bike1);
        Thread t1 = new Thread(() -> lot.parkVehicle(123,customer1));
        Thread t2 = new Thread(() -> lot.parkVehicle(123, customer2));

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        lot.printStatus();
    }
}
