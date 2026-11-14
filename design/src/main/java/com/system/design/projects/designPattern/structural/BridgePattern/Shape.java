package com.system.design.projects.designPattern.structural.BridgePattern;

public abstract class Shape {
    protected Color color;  // Bridge to implementor

    public Shape(Color color) {
        this.color = color;
    }

    public abstract void draw();
}
