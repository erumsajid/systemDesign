package com.system.design.projects.designPattern.structural.proxy;

public class ProxyImage implements Image{

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void display() {
        if (realImage == null) {
            // Lazy initialization
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
