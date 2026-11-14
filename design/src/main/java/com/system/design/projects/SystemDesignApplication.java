package com.system.design.projects;

import com.system.design.projects.JavaQuestions.Java8;
import com.system.design.projects.JavaQuestions.Meeting;
import com.system.design.projects.JavaQuestions.freshwork;
import com.system.design.projects.designPattern.behavioral.command.*;
import com.system.design.projects.designPattern.behavioral.cor.AuthHandler;
import com.system.design.projects.designPattern.behavioral.cor.Request;
import com.system.design.projects.designPattern.behavioral.cor.RequestHandler;
import com.system.design.projects.designPattern.behavioral.cor.RoleHandler;
import com.system.design.projects.designPattern.creational.BackendAbstractFactory;
import com.system.design.projects.designPattern.creational.EmployeeFactory;
import com.system.design.projects.designPattern.creational.URLBuilder;
import com.system.design.projects.designPattern.creational.WebDeveloperAbstractFactory;
import com.system.design.projects.designPattern.structural.BridgePattern.Circle;
import com.system.design.projects.designPattern.structural.BridgePattern.RedColor;
import com.system.design.projects.designPattern.structural.BridgePattern.Shape;
import com.system.design.projects.designPattern.structural.BridgePattern.Square;
import com.system.design.projects.designPattern.structural.Facade.ComputerFacade;
import com.system.design.projects.designPattern.structural.FlyWeight.Forest;
import com.system.design.projects.designPattern.structural.adapter.AudioPlayer;
import com.system.design.projects.designPattern.structural.composite.FileSystem;
import com.system.design.projects.designPattern.structural.composite.FileSystemComponent;
import com.system.design.projects.designPattern.structural.composite.FolderSystem;
import com.system.design.projects.designPattern.structural.decorator.*;
import com.system.design.projects.designPattern.structural.proxy.Image;
import com.system.design.projects.designPattern.structural.proxy.ProxyImage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SystemDesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemDesignApplication.class, args);
        char c1 = '0';
        char c2 = '1';
        int c3 = c1 - '0' + c2;
        System.out.println((char) (c3));
        // factory and abstract factory

//        Factory Method          Abstract Factory
//        ──────────────          ────────────────
//        createTransport()  →    createButton()
//            │                   createCheckbox()
//            ▼                   createTextField()
//        ONE product             │       │       │
//                                ▼       ▼       ▼
//                              FAMILY of related products
        EmployeeFactory backend = new BackendAbstractFactory();
        backend.createEmployee();

        EmployeeFactory web = new WebDeveloperAbstractFactory();
        web.createEmployee();

        //builder pattern
        URLBuilder urlBuilder = new URLBuilder.builder().setProtocol("http:/").setHost("localhost").setPort("8080").build();
        System.out.println(urlBuilder.toString());

//  Decorator Pattern
//  📦 Real Java API Examples of Decorator Pattern
//
//  java.io.InputStream, BufferedInputStream, DataInputStream
//
//  java.util.Collections wrappers (e.g., Collections.synchronizedList)
//
//  java.util.zip streams
//        Component (interface) - coffee
//    └── operation()
//
//        ConcreteComponent
//    └── BasicCoffee / Espresso
//
//        BaseDecorator (abstract, implements Component, wraps Component)
//    └── ConcreteDecorators
//            ├── MilkDecorator
//            ├── SugarDecorator
//            ├── WhipDecorator
//            └── CaramelDecorator
        Coffee coffee = new SimpleCoffee();
        CoffeeDecorator milkCoffee = new MilkCoffee(coffee);
        CoffeeDecorator sugarCoffee = new SugarCoffee(coffee);
        System.out.println(milkCoffee.getDescription());
        System.out.println(sugarCoffee.getDescription());
        System.out.println(coffee.getDescription());

//Adapter Method
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "abc");
        audioPlayer.play("mp4", "abc");
        audioPlayer.play("vlc", "abc");


//proxy pattern  Provides a substitute or placeholder for another object to control access to it.
//        Proxy Type	   Purpose
//        Virtual Proxy	   Lazy loading of heavy objects
//        Protection Proxy Access control / permissions
//        Remote Proxy	   Represent a remote object
//        Logging Proxy	   Track method calls
//        Caching Proxy	   Store results and reuse
    Image img = new ProxyImage("photo.png");

        System.out.println("First display call:");
        img.display();        // loads and displays

        System.out.println("\nSecond display call:");
        img.display();        // uses already loaded image

//Facade Pattern
        ComputerFacade computerFacade = new ComputerFacade();
        computerFacade.start();

//Bridge Pattern
//  Color  <<interface>>
//    ▲
//    │ implements
//    │
//    ├───────────────┐
//    │               │
// RedColor        BlueColor

//        Shape  (abstract class)
//        │
//        │ inheritance
//        ├───────────────┐
//        │               │
//        Circle          Square

//        Bridge Between Shape & Color
//        Shape ---- has a ----> Color
        Shape circle = new Circle(new RedColor());
        circle.draw();

        Shape square = new Square(new RedColor());
        square.draw();

// Composite
        /*It’s especially useful for representing hierarchical tree structures
         (e.g., filesystems, UI components, menus)*/

        FileSystemComponent fileSystemComponent = new FileSystem("abc");
        FileSystemComponent fileSystemComponent1 = new FileSystem("cde");

        FolderSystem folderComponent = new FolderSystem("design");
        folderComponent.addFile(fileSystemComponent);
        folderComponent.addFile(fileSystemComponent1);
        folderComponent.showDetails();

//Flyweight Pattern
       /* Used to reduce memory by sharing intrinsic (immutable) state.
          Extrinsic state is supplied by clients.
          Useful for large numbers of similar objects (e.g., characters in text editor, trees in game maps).*/

        Forest forest = new Forest();

        forest.plantTree(10, 20, "Oak", "Green", "oak_texture.png");
        forest.plantTree(12, 25, "Oak", "Green", "oak_texture.png");
        forest.plantTree(15, 30, "Pine", "Dark Green", "pine_texture.png");

        forest.draw();
//cor
        RequestHandler authHandler = new AuthHandler();
        RequestHandler roleHandler = new RoleHandler();
        Request request = new Request("alex","ADMIN");
        authHandler.setNext(roleHandler);
        authHandler.handle(request);

        //command

        RemoteControl remoteControl = new RemoteControl();
        Light l = new Light();
        Command onCommand = new LightOnCommand(l);
        Command offCommand = new LightOffCommand(l);
        remoteControl.setCommand(onCommand);
        remoteControl.pressButton();
        remoteControl.setCommand(offCommand);
        remoteControl.pressButton();
/*
        The Mediator pattern centralizes communication between related objects (colleagues)
                so they don’t talk to each other directly.
        Instead each colleague talks to the Mediator, which coordinates interaction.
        Great for reducing coupling when many-to-many interactions get messy.
        Common examples:
        GUI frameworks (buttons, text fields), chat rooms, air-traffic control systems.
*/


//
//        meetings = [
//        {start: 1, end: 4, priority: 1, id: "A"},
//        {start: 2, end: 5, priority: 0, id: "B"},
//        {start: 3, end: 6, priority: 2, id: "C"},
//        {start: 4, end: 7, priority: 0, id: "D"},
//        {start: 5, end: 8, priority: 1, id: "E"},
//        {start: 6, end: 9, priority: 0, id: "F"},
//        {start: 7, end: 10, priority: 2, id: "G"},
//        {start: 8, end: 11, priority: 1, id: "H"},
//        {start: 9, end: 12, priority: 0, id: "I"}
//]
//        Meeting m1 = new Meeting(9,11,1,"X");
//        Meeting m2 = new Meeting(10,12,2,"Y");
//        Meeting m3 = new Meeting(12,14,0,"Z");
        List<Meeting> meetings = new ArrayList<>();
        meetings.add(new Meeting(1, 4, 1, "A")); meetings.add(new Meeting(2, 5, 0, "B")); meetings.add(new Meeting(3, 6, 2, "C")); meetings.add(new Meeting(4, 7, 0, "D")); meetings.add(new Meeting(5, 8, 1, "E")); meetings.add(new Meeting(6, 9, 0, "F")); meetings.add(new Meeting(7, 10, 2, "G")); meetings.add(new Meeting(8, 11, 1, "H")); meetings.add(new Meeting(9, 12, 0, "I"));

//        meetingList.add(m1);
//        meetingList.add(m2);
//        meetingList.add(m3);

        List<String> scheduledMeetings = freshwork.scheduleMeetings(meetings);
        System.out.println(scheduledMeetings);
        Java8 java8 = new Java8();
        java8.features();


   }
}
