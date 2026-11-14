package com.system.design.projects.designPattern.structural.decorator;

public abstract class CoffeeDecorator implements Coffee{
    Coffee coffee;
    CoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }
}
