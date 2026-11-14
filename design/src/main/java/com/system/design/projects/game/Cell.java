package com.system.design.projects.game;

public class Cell {
    private int x;
    private int y;
    private Color color;
    Piece currentObject;
    Cell(int x,int y){
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Piece getCurrentObject() {
        return currentObject;
    }

    public void setCurrentObject(Piece currentObject) {
        this.currentObject = currentObject;
    }

    public boolean isAvailable(){
        return  currentObject==null;
    }
}

enum Color {
    WHITE,
    BLACK
}
