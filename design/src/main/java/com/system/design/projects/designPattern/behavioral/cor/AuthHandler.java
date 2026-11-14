package com.system.design.projects.designPattern.behavioral.cor;

public class AuthHandler extends RequestHandler{
    @Override
    protected boolean doHandle(Request request) {
        if(request.getUsername()==null || request.getUsername().isEmpty()){
            return false;
        }
        System.out.println("auth check passed : " + request.getUsername());
        return true;
    }
}
