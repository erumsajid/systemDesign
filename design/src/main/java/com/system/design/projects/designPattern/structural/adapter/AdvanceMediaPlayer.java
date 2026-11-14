package com.system.design.projects.designPattern.structural.adapter;

public class AdvanceMediaPlayer {
    public void playMP4(String fileName){
        System.out.println("playing mp4 - " + fileName);
    }
    public void playVLC(String fileName){
        System.out.println("playing vlc - " + fileName);
    }
}
