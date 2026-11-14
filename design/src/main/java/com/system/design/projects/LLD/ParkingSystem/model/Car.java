package com.system.design.projects.LLD.ParkingSystem.model;

import com.system.design.projects.LLD.ParkingSystem.enums.VehicleType;

public class Car implements Vehicle {

    @Override
    public VehicleType getType() {
        return VehicleType.CAR;
    }
}
