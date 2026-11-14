package com.system.design.projects.LLD.ParkingSystem.model;

import com.system.design.projects.LLD.ParkingSystem.enums.VehicleType;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ParkingFloor {
    private final String id;
    private final Map<String, ParkingSpot> spots = new HashMap<>();
    public ParkingFloor(String id) { this.id = id; }

    public void addSpot(ParkingSpot spot) {
        spots.put(spot.getId(), spot);
    }

    public ParkingSpot findAvailableSpot(VehicleType vehicleType) {
        for (ParkingSpot spot : spots.values()) {
            if (spot.getAllowedType() == vehicleType && spot.tryOccupy()) {
                return spot;
            }
        }
        return null;
    }
}
