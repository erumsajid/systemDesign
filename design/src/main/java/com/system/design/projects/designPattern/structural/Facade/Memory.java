package com.system.design.projects.designPattern.structural.Facade;

public class Memory {
    public void load(long location,String data){
        System.out.println("Loading data '" + data + "' into memory at position " + location);
    }
}
