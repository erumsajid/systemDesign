package com.system.design.projects.designPattern.structural.Facade;

public class ComputerFacade {
    private CPU cpu;
    private HardDrive hardDrive;
    private Memory memory;
    public ComputerFacade(){
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }
    public void start(){
        System.out.println("starting computer..........");
        cpu.freeze();
        hardDrive.read(123,5);
        memory.load(1234,"demo");
        cpu.execute();
        System.out.println("Computer started successfully!");
    }
}
