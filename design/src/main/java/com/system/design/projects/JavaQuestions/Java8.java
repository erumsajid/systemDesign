package com.system.design.projects.JavaQuestions;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8 {

    public void features(){
        //for each
        List<String> names = new ArrayList<>();
        names.add("A");
        names.add("B");
        names.add("C");
        names.add("D");

        names.forEach(System.out :: println);
        MyInterface myInterface = new MyInterface() {
            @Override
            public void print() {
                System.out.println("overriden in anonymous class");
            }
        };
        myInterface.defaultMethod("default");
        MyInterface.staticMethod("static method of interface");

        MyFunctionalInterface greet = name -> System.out.println("name -- " + name);
        greet.geet("functional Interface");
        System.out.println("end--------");

        /// API stream fucntion

        List<String> res = names.stream().filter( name -> name.startsWith("A"))
                .map( name -> "filtered name - " + name).toList();
        String res1 = names.stream().filter( name -> name.startsWith("A"))
                .map( name -> "filtered name - " + name).collect(Collectors.joining(","));

        System.out.println("res--" + res);
        System.out.println("res1--" + res1);

        ///
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable task = () -> System.out.println("task executed by " + Thread.currentThread().getName());

        executorService.submit(task);
        executorService.submit(task);

        executorService.shutdown();

        //optional
        Optional<String> name = Optional.ofNullable(names.get(0));
        name.ifPresent(System.out::println);
        name.ifPresentOrElse(System.out::println,task);

         Student student1 = new Student(1,"A1",30,"Male","CSE","Mumbai",123,List.of());
         Student student2 = new Student(2,"A2",33,"Male","ECE","DELHI",100,List.of());
         Student student3 = new Student(3,"A3",35,"Female","ECE","DELHI",50,List.of());
         Student student4 = new Student(4,"A4",36,"Female","CSE","Mumbai",30,List.of());
         List<Student> studentList = List.of(student1,student2,student3,student4);
         List<Student> newList = studentList.stream().filter( student -> student.getRank()>30 && student.getRank()<123).toList();
         System.out.println("list -- "+newList);
         List<Student> sortedStudent = studentList.stream().sorted(Comparator.comparing(Student::getFirstName)).toList();
         System.out.println("list -- "+sortedStudent);
         List<Student> revsortStudent = studentList.stream().sorted(Comparator.comparing(Student::getFirstName,Comparator.reverseOrder())).toList();

         //list of department
        List<String> deps = studentList.stream().map(Student::getDept).distinct().toList();
        Set<String> depSet = studentList.stream().map(Student::getDept).collect(Collectors.toSet());

        List<List<Integer>> listOfListNum = studentList.stream().map(Student::getNumbers).distinct().toList();

        //map return list of list , will use flatmap
        List<Integer> listOfNum = studentList.stream().flatMap(student -> student.getNumbers().stream()).distinct().toList();

        //oneToOne -> map
        //oneToMany -> map


        //grouping by dep
        Map<String,List<Student>> studentMapByDept = studentList.stream().
                collect(Collectors.groupingBy(Student::getDept));

        System.out.println(studentMapByDept + "-----");

        Map<String,Long> studentCountMapByDept = studentList.stream().
                collect(Collectors.groupingBy(Student::getDept,Collectors.counting()));

        System.out.println(studentCountMapByDept + "-----");

        Map.Entry<String,Long> maxStudentCountMapByDept = studentList.stream().
                collect(Collectors.groupingBy(Student::getDept,Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();

        System.out.println(maxStudentCountMapByDept + "-----");

        Map<String,Double> studentAgeAvgMapByGender = studentList.stream()
                .collect(Collectors.groupingBy(Student::getGender
                        ,Collectors.averagingInt(Student :: getAge)));
        System.out.println(studentAgeAvgMapByGender + "-----");

        Map<String,Optional<Student>> minStudentByGender = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDept
                        ,Collectors.minBy(Comparator.comparing(Student:: getRank))));
        System.out.println(minStudentByGender + "-----");

        Student secondHighest = studentList.stream().sorted(Comparator.comparing(Student::getRank)).skip(1).findFirst().get();
        int maxRank = studentList.stream().max(Comparator.comparing(Student::getRank)).stream().skip(1).mapToInt(Student :: getRank).max().getAsInt();
        String str = "abcdab";
        Map<Character, Long> result = str.chars()          // IntStream
                .mapToObj(c -> (char) c)                   // Stream<Character>
                .collect(Collectors.groupingBy(
                        Function.identity(),               // group by character
                        Collectors.counting()              // count occurrences
                ));
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);

        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(2);

        Stream.concat(l1.stream(),l2.stream()).sorted().distinct().toList();


        //executor frame work
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.submit(() -> System.out.println("thread name - " + Thread.currentThread().getName()));
        Future<String> future =  service.submit(() -> "thread name - " + Thread.currentThread().getName());

        try {
            System.out.println("result - " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        service.shutdown();

    }
}
