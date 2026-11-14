package com.system.design.projects.ParkingSystem;

public class CarParkingFeeStrategy extends ParkingFeeStrategy {
    @Override
    double getParkingAmountPerMinute() {
        return 20.0;
    }
}
