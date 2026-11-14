package com.system.design.projects.designPattern.behavioral.observer;

public class Subscriber implements Observer{
    @Override
    public void update(String name) {
        System.out.println("New video is uploaded by " + name);
    }
}
