package com.system.design.projects.InventoryLockerSystem;

public class BruteForceStrategy implements InventoryOperationStrategy{
    @Override
    public boolean addItemStrategy(Item item, Locker locker) {
        item.setLocker(locker);
        locker.setItem(item);
        return false;
    }

    @Override
    public Locker findBestLocker(Item item,Storage storage) {
        //find best locker
        return storage.getLockerGrid()[0][0];
    }

    @Override
    public boolean removeItemStrategy(Item item) {
        Locker locker = item.getLocker();
        locker.setItem(null);
        item.setLocker(null);
        return true;
    }
}
