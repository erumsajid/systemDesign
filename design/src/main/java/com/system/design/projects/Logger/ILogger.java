package com.system.design.projects.Logger;

public interface ILogger {
    boolean addProcess(Process process);
    boolean endProcess(Process process);
    String poll();
}
