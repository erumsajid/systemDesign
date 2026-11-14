package com.system.design.projects.ParkingSystem;

public class ParkingSlot {
    private int slotNo;
    private VEHICLETYPE type;
    private int vehicleId;

    public int getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }

    public VEHICLETYPE getType() {
        return type;
    }

    public void setType(VEHICLETYPE type) {
        this.type = type;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
    public boolean isVacant(){
        return vehicleId>0;
    }
}
