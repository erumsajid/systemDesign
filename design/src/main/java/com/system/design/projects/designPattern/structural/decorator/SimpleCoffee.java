package com.system.design.projects.designPattern.structural.decorator;

public class SimpleCoffee implements Coffee{
    @Override
    public String getDescription() {
        return "simple coffee";
    }

    @Override
    public double getCost() {
        return 15;
    }
}
