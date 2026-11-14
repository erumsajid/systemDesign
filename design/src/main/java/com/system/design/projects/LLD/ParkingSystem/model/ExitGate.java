package com.system.design.projects.LLD.ParkingSystem.model;

import com.system.design.projects.LLD.ParkingSystem.enums.GateType;

public class ExitGate implements Gate{
    @Override
    public GateType getGateType() {
        return GateType.EXIT_GATE;
    }
}
