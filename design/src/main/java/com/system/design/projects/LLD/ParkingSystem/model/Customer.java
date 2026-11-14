package com.system.design.projects.LLD.ParkingSystem.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    String name;
    String govId;
    Vehicle vehicle;
}
