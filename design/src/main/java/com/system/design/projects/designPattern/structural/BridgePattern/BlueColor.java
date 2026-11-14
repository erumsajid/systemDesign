package com.system.design.projects.designPattern.structural.BridgePattern;

public class BlueColor implements Color{
    @Override
    public void applyColor() {
        System.out.println("applying blue colour");
    }
}
//Interview tip: Bridge Pattern uses composition to separate abstraction from implementation.
//
//Remember: Bridge = Two independent dimensions connected through composition.