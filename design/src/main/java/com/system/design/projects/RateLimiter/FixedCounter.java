package com.system.design.projects.RateLimiter;

public class FixedCounter implements RateLimiterAlgorithm{
    private final long fixedTokenCount;
    private volatile long token;
    private final long refillRate;
    FixedCounter(long maxToken,long refillRate){
        this.fixedTokenCount = maxToken;
        this.token = maxToken;
        this.refillRate = refillRate;

    }
    @Override
    public boolean grantAccess() {
        return consumeToken();
    }
    public synchronized void refillCounter(){
        System.out.println("Refilling the token");
        this.token = fixedTokenCount;
    }
    public long getToken(){
        return token;
    }
    public synchronized boolean consumeToken(){
        if(getToken()==0){
            return false;
        }
        this.token--;
        System.out.println("Using token");
        return true;
    }

    public long getRefillRate() {
        return refillRate;
    }

    public long getFixedTokenCount() {
        return fixedTokenCount;
    }
}
