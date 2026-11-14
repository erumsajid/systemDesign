package com.system.design.projects.LLD.ParkingSystem.factory;

import com.system.design.projects.LLD.ParkingSystem.model.Car;
import com.system.design.projects.LLD.ParkingSystem.model.Vehicle;

public class CarAbstractFactory implements VehicleFactory{
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}
