package com.system.design.projects.ParkingSystem;

public class ParkingFeeFactory {

    static ParkingFeeStrategy getFeeStrategy(VEHICLETYPE vehicletype){
        if(vehicletype.equals(VEHICLETYPE.CAR)){
            return new CarParkingFeeStrategy();
        }
        return new CarParkingFeeStrategy();
    }
}
