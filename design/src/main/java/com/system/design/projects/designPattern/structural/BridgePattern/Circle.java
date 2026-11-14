package com.system.design.projects.designPattern.structural.BridgePattern;

public class Circle extends Shape{

    public Circle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("drawing circle");
        color.applyColor();
    }
}
