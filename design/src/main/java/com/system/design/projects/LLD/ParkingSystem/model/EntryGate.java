package com.system.design.projects.LLD.ParkingSystem.model;

import com.system.design.projects.LLD.ParkingSystem.enums.GateType;

public class EntryGate implements Gate{
    @Override
    public GateType getGateType() {
        return GateType.ENTRY_GATE;
    }
    public Ticket parkVehicle(long entryTime,Customer client){
        Ticket ticket = new Ticket();

        return ticket;
    }
}
