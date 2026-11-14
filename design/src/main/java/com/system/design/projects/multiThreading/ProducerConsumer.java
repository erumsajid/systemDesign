package com.system.design.projects.multiThreading;

public class ProducerConsumer {
    int value = 0;

    synchronized void addValue(int x){
        System.out.println("enter --"+Thread.currentThread().getName() +"--"+value);
        while(value!=0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        value =1;
        notifyAll();
        System.out.println(Thread.currentThread().getName() +"--"+value);
    }
    synchronized void removeValue(int x){
        System.out.println("enter --"+Thread.currentThread().getName() +"--"+value);
        while(value==0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        value--;
        notifyAll();
        System.out.println(Thread.currentThread().getName() +"--"+value);
    }
}
