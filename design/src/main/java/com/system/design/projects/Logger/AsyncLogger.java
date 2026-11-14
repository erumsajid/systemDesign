package com.system.design.projects.Logger;

import com.system.design.projects.Logger.Process;
import java.util.concurrent.BlockingQueue;

public class AsyncLogger implements Runnable {
    private final BlockingQueue<Process> completedProcess;
    private boolean start;

    public AsyncLogger(BlockingQueue<Process> completedProcess) {
        this.completedProcess = completedProcess;
        this.start = true;
    }

    @Override
    public void run() {
        while(start){
            Process process = null;
            try {
                process = completedProcess.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Process id : "+ process.getProcessId() +"started At " + process.getStartTime() + "ended at " + process.getEndTime());
        }
    }

    public void stop(){
        start = false;
    }
}
