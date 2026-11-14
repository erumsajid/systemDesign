package com.system.design.projects.designPattern.creational;

public class WebDeveloperAbstractFactory implements EmployeeFactory{
    @Override
    public Employee createEmployee() {
        System.out.println("Web Developer");
        return new WebDeveloper();
    }
}
