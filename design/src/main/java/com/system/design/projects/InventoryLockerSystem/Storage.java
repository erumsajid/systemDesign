package com.system.design.projects.InventoryLockerSystem;

public class Storage {
    private int id;
    private Location location;
    private Locker[][] lockerGrid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Locker[][] getLockerGrid() {
        return lockerGrid;
    }

    public void setLockerGrid(Locker[][] lockerGrid) {
        this.lockerGrid = lockerGrid;
    }
}
