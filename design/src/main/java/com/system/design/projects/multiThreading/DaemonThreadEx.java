package com.system.design.projects.multiThreading;

public class DaemonThreadEx implements Runnable {
    @Override
    public void run() {
        int count = 0;
        while(count<500){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
            System.out.println("Daemon thread running ............");
        }

    }
}
