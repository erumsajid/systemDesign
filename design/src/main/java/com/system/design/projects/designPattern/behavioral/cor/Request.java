package com.system.design.projects.designPattern.behavioral.cor;

public class Request {
    private final String username;
    private final String role;
    public Request(String username, String role){
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
}
