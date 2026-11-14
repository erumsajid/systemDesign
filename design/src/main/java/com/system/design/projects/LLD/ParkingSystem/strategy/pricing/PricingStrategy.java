package com.system.design.projects.LLD.ParkingSystem.strategy.pricing;

import com.system.design.projects.LLD.ParkingSystem.enums.VehicleType;

public interface PricingStrategy {
    double calculateFee(VehicleType vehicleType,long entryTime,long exitTime);
}
