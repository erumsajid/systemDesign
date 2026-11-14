package com.system.design.projects.JavaQuestions;

public interface MyInterface {
    default void defaultMethod(String name){
        System.out.println(name);
    }

    default void defaultMethod2(String name){
        System.out.println(name);
    }

    static void staticMethod(String name){
        System.out.println(name);
    }
    static void staticMethod2(String name){
        System.out.println(name);
    }
    void print();
}
