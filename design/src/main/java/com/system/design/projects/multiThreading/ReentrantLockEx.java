package com.system.design.projects.multiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockEx {
    private static int sharedData = 0;
    private static final Lock lock = new ReentrantLock();

    public void methodA(){
        lock.lock();
        try{
            sharedData++;
            System.out.println("method a "+sharedData);
            methodB();
        }finally {
            lock.unlock();
        }
    }
    public void methodB(){
        lock.lock();
        try{
            sharedData--;
            System.out.println("method b "+sharedData);
        }finally {
            lock.unlock();
        }
    }

    public static void main(String args[]){
        ReentrantLockEx ex = new ReentrantLockEx();
        ex.methodA();
    }


}
