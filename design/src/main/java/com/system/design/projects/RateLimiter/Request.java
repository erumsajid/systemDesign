package com.system.design.projects.RateLimiter;

public class Request{
    Header header;
    int getUserId(){
        String token = header.getToken();
        return token.length();
    }
}
