package com.system.design.projects.multiThreading;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ConcurrentHashMapEx {
    private static final Map<String,String> cache = new ConcurrentHashMap<>();

    public static void main(String args[]){
        for(int i=0;i<10;i++){
            new Thread(() -> {
                for(int j=0;j<3;j++){
                    String value = getCache(j+"");
                    System.out.println("got the value "+ value + "  "+Thread.currentThread().getName());
                    System.out.println(cache.size());
                }
            }).start();
        }

    }

    private static String getCache(final String key){
        if(cache.get(key)==null){
            System.out.println("key not present : " + key);
            cache.put(key,"value : - "+ key);
        }
        return cache.get(key);

    }
}
