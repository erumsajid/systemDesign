package com.system.design.projects.InventoryLockerSystem;

public interface InventoryOperationStrategy {
    boolean addItemStrategy(Item item,Locker locker);
    Locker findBestLocker(Item item,Storage storage);
    boolean removeItemStrategy(Item item);


}
