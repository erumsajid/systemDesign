package com.system.design.projects.designPattern.behavioral.cor;

public abstract class RequestHandler {
    private RequestHandler next;
    public RequestHandler setNext(RequestHandler handler){
        next = handler;
        return handler;
    }
    public void handle(Request request){
        if(doHandle(request)){
            if(next!=null){
                next.handle(request);
            }

        }
    }
    protected abstract boolean doHandle(Request request);
}
