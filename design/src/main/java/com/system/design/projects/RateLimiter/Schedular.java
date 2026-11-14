package com.system.design.projects.RateLimiter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Schedular {
    private final FixedCounter rateLimiterAlgorithm;
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();


    public Schedular(FixedCounter rateLimiterAlgorithm) {
        this.rateLimiterAlgorithm = rateLimiterAlgorithm;
    }

    public void start() {
        scheduler.scheduleAtFixedRate(
                this :: refill,
                rateLimiterAlgorithm.getRefillRate(), // initial delay
                rateLimiterAlgorithm.getRefillRate(),
                TimeUnit.MILLISECONDS);
    }
    public void refill(){
        rateLimiterAlgorithm.refillCounter();

    }
}
