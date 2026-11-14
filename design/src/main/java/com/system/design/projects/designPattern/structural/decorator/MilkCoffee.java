package com.system.design.projects.designPattern.structural.decorator;

public class MilkCoffee extends CoffeeDecorator{
    public MilkCoffee(Coffee coffee) {
        super(coffee);
    }
    @Override
    public String getDescription() {
        return coffee.getDescription() + " and with milk";
    }

    @Override
    public double getCost() {
        return 5 + coffee.getCost();
    }
}
