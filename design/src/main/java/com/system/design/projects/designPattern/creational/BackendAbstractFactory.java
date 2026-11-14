package com.system.design.projects.designPattern.creational;

public class BackendAbstractFactory implements EmployeeFactory{
    @Override
    public Employee createEmployee() {
        System.out.println("Backend Developer");
        return new BackendDeveloper();
    }
}
