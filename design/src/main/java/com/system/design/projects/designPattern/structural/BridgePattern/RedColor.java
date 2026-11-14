package com.system.design.projects.designPattern.structural.BridgePattern;

public class RedColor implements Color{
    @Override
    public void applyColor() {
        System.out.println("applying red colour");
    }
}
