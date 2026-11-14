package com.system.design.projects.designPattern.structural.decorator;

public class SugarCoffee extends CoffeeDecorator{
    public SugarCoffee(Coffee coffee) {
        super(coffee);
    }
    @Override
    public String getDescription() {
        return coffee.getDescription() + " and with sugar";
    }

    @Override
    public double getCost() {
        return 5 + coffee.getCost();
    }
}
