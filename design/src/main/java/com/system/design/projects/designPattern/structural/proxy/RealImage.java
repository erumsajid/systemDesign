package com.system.design.projects.designPattern.structural.proxy;

public class RealImage implements Image{
    private final String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        load();
    }

    public void load() {
        System.out.println("loading image" + fileName);
    }

    @Override
    public void display() {
        System.out.println("display image");
    }
}
