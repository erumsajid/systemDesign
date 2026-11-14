package com.system.design.projects.multiThreading;

import java.util.concurrent.Semaphore;

public class SemaphoreEx {
    public static Semaphore semaphore = new Semaphore(3);
    public static void main(String args[]){
        for(int i=0;i<10;i++){
            new Thread(() -> {
                try {
                    callThirdPart();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
    public static void callThirdPart() throws InterruptedException {
        semaphore.acquire();
        try {
            paymentMethod();
            Thread.sleep(2000);
        }finally {
            semaphore.release();
        }

    }
    public static void paymentMethod(){
         System.out.println("running payment method ");
    }

}
