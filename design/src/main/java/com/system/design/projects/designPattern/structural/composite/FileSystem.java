package com.system.design.projects.designPattern.structural.composite;

public class FileSystem implements FileSystemComponent{
    String fileName;
    public FileSystem(String fileName){
        this.fileName = fileName;
    }
    @Override
    public void showDetails() {
        System.out.println("fileName : "+fileName);
    }
}
