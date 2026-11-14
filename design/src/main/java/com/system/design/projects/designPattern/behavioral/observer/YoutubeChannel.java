package com.system.design.projects.designPattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel {
    List<Subscriber> subscriberList;
    YoutubeChannel(List<Subscriber> subscriberList){
        this.subscriberList = new ArrayList<>();
    }
    public boolean addSubscriber(Subscriber subscriber){
        subscriberList.add(subscriber);
        return true;
    }
    public boolean removeSubscriber(Subscriber subscriber){
        subscriberList.add(subscriber);
        return true;
    }
    public void notifySubscriber(){
        for(Subscriber subscriber : subscriberList){
            subscriber.notify();
        }
    }
}
