package com.system.design.projects.ParkingSystem;

public abstract class Vehicle {
    private int vehicleNo;
    abstract VEHICLETYPE getVehicleType();

    public int getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(int vehicleNo) {
        this.vehicleNo = vehicleNo;
    }
}
