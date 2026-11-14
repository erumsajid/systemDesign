package com.system.design.projects.LLD.ParkingSystem.model;

import com.system.design.projects.LLD.ParkingSystem.enums.VehicleType;

public class Bike implements Vehicle {
    @Override
    public VehicleType getType() {
        return VehicleType.BIKE;
    }
}
