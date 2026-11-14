package com.system.design.projects.RateLimiter;

public class RateLimiter {
    private final RateLimiterAlgorithm rateLimiterAlgorithm;

    public RateLimiter(RateLimiterAlgorithm rateLimiterAlgorithm) {
        this.rateLimiterAlgorithm = rateLimiterAlgorithm;
    }


    public boolean grantAccess(Request request) {
        return rateLimiterAlgorithm.grantAccess();
    }
}



