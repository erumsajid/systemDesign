package com.system.design.projects.LLD.ParkingSystem.strategy.pricing;

import com.system.design.projects.LLD.ParkingSystem.enums.VehicleType;

public class TimeBasedPricing implements PricingStrategy{
    @Override
    public double calculateFee(VehicleType vehicleType, long entryTime, long exitTime) {
        return 0;
    }
}
