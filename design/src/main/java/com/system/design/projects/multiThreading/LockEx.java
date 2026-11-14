package com.system.design.projects.multiThreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockEx {
    private final int max = 5;
    private final Lock lock = new ReentrantLock();
    private final Condition bufferNotEmpty = lock.newCondition();
    private final Condition bufferNotFull = lock.newCondition();
    private final Queue<Integer> q = new LinkedList<>();

    public void producer(int i) throws InterruptedException {
        lock.lock();
        try {
            while(q.size()==max){
                bufferNotEmpty.await();
            }
            q.add(i);
            System.out.println("added in the queue -" + i);
            bufferNotFull.signal();
        }finally {
            lock.unlock();
        }
    }
    public void consumer() throws InterruptedException {
        lock.lock();
        try {
            while(q.isEmpty()){
                bufferNotFull.await();
            }
            System.out.println("consume by thread : - "+q.poll());
            bufferNotEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String args[]){
        LockEx lockEx = new LockEx();


            new Thread(() ->{
                for(int i=0;i<10;i++){
                    try {
                        lockEx.producer(i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            } ).start();
        new Thread(() ->{
            for(int i=0;i<10;i++){
                try {
                    lockEx.consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } ).start();

    }

}
