package com.system.design.projects.designPattern.structural.FlyWeight;

public class Tree {
    private int x;
    private int y;
    private TreeType type; // shared flyweight

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y);  // extrinsic state passed here
    }
}
