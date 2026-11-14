package com.system.design.projects.InventoryLockerSystem;

import java.util.List;
import java.util.Map;

public class LockerManagementSystem {
    List<Product> productList;
    Map<String,Item> itemMaps;
    Storage storage;
    InventoryOperationStrategy inventoryOperationStrategy;

    boolean addItem(Item item){
        Locker locker = inventoryOperationStrategy.findBestLocker(item,storage);
        inventoryOperationStrategy.addItemStrategy(item,locker);
        return true;
    }
    boolean removeItem(Item item){
        inventoryOperationStrategy.removeItemStrategy(item);
        return true;
    }
    Item findItem(String name){
        return  itemMaps.get(name);
    }
}
