package com.system.design.projects.designPattern.behavioral.cor;

public class RoleHandler extends RequestHandler{
    @Override
    protected boolean doHandle(Request request) {
        if(request.getRole().equals("ADMIN")){
            System.out.println("Role check of user is passed :" +request.getRole());
            return true;
        }
        return false;
    }
}
