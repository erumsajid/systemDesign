package com.system.design.projects.designPattern.structural.adapter;

public class MediaAdapter implements MediaPlayer{
    private final AdvanceMediaPlayer advanceMediaPlayer;
    MediaAdapter(){
        advanceMediaPlayer = new AdvanceMediaPlayer();
    }
    @Override
    public void play(String audioType,String fileName) {
        if(audioType.equalsIgnoreCase("mp4")){
            advanceMediaPlayer.playMP4(fileName);
        }else if(audioType.equalsIgnoreCase("vlc")){
            advanceMediaPlayer.playVLC(fileName);
        }else{
            System.out.println("not supported audio type");
        }
    }
}
