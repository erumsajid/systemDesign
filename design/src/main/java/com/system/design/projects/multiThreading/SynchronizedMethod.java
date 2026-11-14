package com.system.design.projects.multiThreading;

public class SynchronizedMethod {

    public static int counter1;
    public static int counter2;
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
    public static void main(String args[]) throws InterruptedException {
        Thread t1 = new Thread(()  -> {
            for (int i=0;i<5;i++){
                increase1();
            }

        });

        Thread t2 = new Thread(()  -> {
            for (int i=0;i<5;i++){
                increase2();
            }

        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
    public static void increase1(){
        synchronized(lock1){
            counter1++;
            System.out.println("increase1 --" + counter1);
        }
    }
    public static void increase2(){
        synchronized(lock1){
            counter2++;
            System.out.println("increase2 --" + counter2);
        }
    }
}
