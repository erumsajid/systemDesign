package com.system.design.projects.multiThreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerEx {

    private static AtomicInteger atomic = new AtomicInteger(0);

    public static void increase(){
          for(int i=0;i<1000;i++) {
              atomic.getAndIncrement();
          }
    }
    public static void increase2(){
        for(int i=0;i<1000;i++) {
            atomic.getAndIncrement();
        }
    }
    public static void main(String args[]) throws InterruptedException {
        Thread t1= new Thread(AtomicIntegerEx::increase);
        t1.start();
        Thread t2= new Thread(AtomicIntegerEx::increase2);
        t2.start();

        t1.join();
        t2.join();

        System.out.println("count "+ atomic.get());

    }
}
