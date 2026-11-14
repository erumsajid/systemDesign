package com.system.design.projects.designPattern.structural.Facade;

public class HardDrive {
    public String read(long lba, int size) {
        return "BOOT_DATA";  // pretend to read boot data
    }
}
