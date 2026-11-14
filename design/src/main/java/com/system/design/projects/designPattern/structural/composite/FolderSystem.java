package com.system.design.projects.designPattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class FolderSystem implements FileSystemComponent{
    String folderName;
    List<FileSystemComponent> fileSystemList;
    public FolderSystem(String folderName){
        this.folderName = folderName;
        fileSystemList = new ArrayList<>();
    }
    public void addFile(FileSystemComponent fileSystem){
        fileSystemList.add(fileSystem);
    }
    public void removeFile(FileSystemComponent fileSystem){
        fileSystemList.remove(fileSystem);
    }
    @Override
    public void showDetails() {
        System.out.println("folder Name : " + folderName);
        fileSystemList.forEach(FileSystemComponent::showDetails);
    }
}
