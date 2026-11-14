package com.system.design.projects.LLD.ParkingSystem.factory;

import com.system.design.projects.LLD.ParkingSystem.model.Bike;
import com.system.design.projects.LLD.ParkingSystem.model.Vehicle;

public class BikeAbstractFactory implements VehicleFactory{
    @Override
    public Vehicle createVehicle() {
        return new Bike();
    }
}
