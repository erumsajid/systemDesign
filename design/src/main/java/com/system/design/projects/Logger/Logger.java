package com.system.design.projects.Logger;

import java.time.LocalDateTime;
import java.util.TreeMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Logger{
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Process> completedProcess = new LinkedBlockingQueue<Process>();
        Process p1 = new Process();
        p1.setProcessId(1);
        p1.setStartTime(LocalDateTime.now().getMinute());
        Process p2 = new Process();
        p1.setProcessId(2);
        p1.setStartTime(LocalDateTime.now().getMinute());
        ProcessManagement processManagement = new ProcessManagement(completedProcess,new TreeMap<>());
        processManagement.startProcess(p1);
        processManagement.startProcess(p2);
        AsyncLogger asyncLogger = new AsyncLogger(completedProcess);
        Thread thread = new Thread(asyncLogger);
        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        processManagement.endProcess(p1.getProcessId());
        processManagement.endProcess(p2.getProcessId());

    }
}
