package com.system.design.projects.multiThreading;

import java.util.concurrent.CountDownLatch;

public class Restaurant {
    public static void main(String args[]) throws InterruptedException {
          int numOfChef = 3;
          CountDownLatch latch = new CountDownLatch(3);
          chef chef1 = new chef("pizza",latch);
          chef chef2 = new chef("bread",latch);
          chef chef3 = new chef("fries",latch);

          new Thread(chef1).start();
          new Thread(chef2).start();
          new Thread(chef3).start();
          latch.await();

    }

}
class chef implements Runnable{
    String food;
    CountDownLatch countDownLatch;
    chef(String food,CountDownLatch countDownLatch){
        this.food = food;
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        System.out.println("chef is preparing food "+food);
        try {
            Thread.sleep(2000);
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("food is prepared "+food);
    }
}
