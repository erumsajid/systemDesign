package com.system.design.projects.LLD.ParkingSystem.model;

import com.system.design.projects.LLD.ParkingSystem.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicBoolean;

@AllArgsConstructor
@Setter
@Getter
public class ParkingSpot {
    private final String id;
    private final VehicleType allowedType;
    private AtomicBoolean isOccupied;
    private Vehicle parkedVehicle;

    public ParkingSpot(String id,VehicleType vehicleType){
        this.id = id;
        this.allowedType = vehicleType;
        isOccupied = new AtomicBoolean();
        isOccupied.set(false);
    }
    public boolean getIsOccupied() {
        return isOccupied.get();
    }
    public boolean tryOccupy() {
        try {
            return isOccupied.compareAndSet(false,true);
        }catch (Exception exception){
            System.out.println("Parking is booked");
        }
        return false;

    }
    public void vacate() {
        isOccupied.set(false);
    }

}
