package com.system.design.projects.Logger;

import com.system.design.projects.Logger.Process;
import java.time.LocalDateTime;
import java.util.TreeMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ProcessManagement {
    private final BlockingQueue<Process> completedProcess;
    private final TreeMap<Integer,Process> processTreeMap;


    public ProcessManagement(BlockingQueue<Process> completedProcess, TreeMap<Integer,Process> processTreeMap) {
        this.completedProcess = completedProcess;
        this.processTreeMap = processTreeMap;
    }

    public String startProcess(Process process){
        processTreeMap.put(process.getProcessId(),process);
        return "Process added";
    }

    public boolean endProcess(int processId) throws InterruptedException {
        if(!processTreeMap.containsKey(processId)){
            System.out.println("Process not found " + processId);
            return false;
        }
        Process end = processTreeMap.get(processId);
        end.setEndTime(LocalDateTime.now().getMinute());
        return completedProcess.offer(end,5, TimeUnit.MILLISECONDS);
    }


}
