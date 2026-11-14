package com.system.design.projects.multiThreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierEx {
    static final int TOURIST_MAX = 5;
    final static int MAX_STAGE = 3;

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(TOURIST_MAX,() ->
            System.out.println("Tourist guide is speaking -------"));

    public static void main(String args[]){
        for(int i=0;i<TOURIST_MAX;i++){
            new Thread(new Tourist(i)).start();
        }
    }

    static class Tourist implements Runnable{
        int id;
        Tourist(int id){
            this.id = id;
        }
        @Override
        public void run() {
            for(int i=0;i<MAX_STAGE;i++){
                try {
                    Thread.sleep(1000);
                    System.out.println("Toursit id "+id + " stage  "+i);
                    cyclicBarrier.await();

                }catch (InterruptedException | BrokenBarrierException bx){
                     throw  new RuntimeException();
                }


            }
        }
    }

}



