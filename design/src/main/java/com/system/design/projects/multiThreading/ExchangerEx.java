package com.system.design.projects.multiThreading;

import java.util.concurrent.Exchanger;

public class ExchangerEx {
       public static void main(String args[]){
           Exchanger<Integer> exchanger = new Exchanger<>();
           Thread firstThread = new Thread(new FirstThread(exchanger));
           Thread secondThread = new Thread(new SecondThread(exchanger));
           firstThread.start();
           secondThread.start();
       }
}
class FirstThread implements Runnable{
    private final  Exchanger<Integer> ex;

    FirstThread(Exchanger<Integer> ex) {
        this.ex = ex;
    }

    @Override
    public void run() {
        System.out.println("sending data 1 thread - " + 10);
        try {
            Integer rec = ex.exchange(10);
            System.out.println("receive data 1 thread - " + rec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
class SecondThread implements Runnable{
    private final  Exchanger<Integer> ex;

    SecondThread(Exchanger<Integer> ex) {
        this.ex = ex;
    }

    @Override
    public void run() {
        System.out.println("sending data 2 thread - " + 20);
        try {
            Integer rec = ex.exchange(20);
            System.out.println("receive data 2 thread - " + rec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
