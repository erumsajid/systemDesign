package com.system.design.projects.designPattern.structural.adapter;

public class AudioPlayer implements MediaPlayer{
    private final MediaAdapter mediaAdapter;
    public AudioPlayer(){
        mediaAdapter = new MediaAdapter();
    }
    @Override
    public void play(String audioType,String fileName) {
        if(audioType.equalsIgnoreCase("mp3")){
            System.out.println("playing mp3 - " + fileName);
        }else{
            mediaAdapter.play(audioType,fileName);
        }
    }
}
