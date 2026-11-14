package com.system.design.projects.RateLimiter;

public class Main {
    public static void main(String args[]) throws InterruptedException {

        FixedCounter rateLimiterAlgorithm = new FixedCounter(4,60000);

        Schedular schedular = new Schedular(rateLimiterAlgorithm);
        schedular.start();
        RateLimiter rateLimiter = new RateLimiter(rateLimiterAlgorithm);
        Request request = new Request();

        rateLimiter.grantAccess(request);
        rateLimiter.grantAccess(request);
        rateLimiter.grantAccess(request);
        rateLimiter.grantAccess(request);
        rateLimiter.grantAccess(request);



    }
}

