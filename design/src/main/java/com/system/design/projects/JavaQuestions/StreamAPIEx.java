package com.system.design.projects.JavaQuestions;



import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIEx {
    public static void main(String args[]){
        StreamAPIEx.streamAPIQuestion();
    }
    public static void streamAPIQuestion(){
        //find the word that has highest length
        String q1 = "i am learning stream";
        String a1 = Arrays.stream(q1.split(" ")).max(Comparator.comparing(String::length)).get();

        System.out.println(a1);
        //remove duplicates from the string and return in same order
        String q2 = "aabbcde";
        String a2 = Arrays.stream(q2.split(""))
                .distinct().collect(Collectors.joining(""));
        q2.chars().distinct().mapToObj(s -> (char)s).forEach(System.out::print);
        System.out.println(a2);

        //find the second largest
        String a3 = Arrays.stream(q1.split(" ")).sorted(Comparator.comparing(String::length,Collections.reverseOrder())).skip(1).findFirst().get();
        System.out.println(a3);

        //find the second largest length
        int a4 = Arrays.stream(q1.split(" ")).map(String::length).sorted(Comparator.comparing(x->x,Collections.reverseOrder())).skip(1).findFirst().get();
        System.out.println(a4);

        //count words
        String q3 = "i am learning stream stream api api";
        Map<String,Long> map = Arrays.stream(q3.split(" ")).collect(Collectors.groupingBy(x->x,Collectors.counting()));
        System.out.println(map);
        //find the word with specified number of vowels = 2
        List<String> a5 = Arrays.stream(q1.split(" ")).filter(s-> s.replaceAll("[^aeiou]","").length()==2).toList();
        System.out.println(a5);

        int[] arr = {1,2,3,4,5,6};
        Map<Boolean,List<Integer>> oddEven = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(x-> x%2==0));
        List<List<Integer>> list = oddEven.entrySet().stream().map( x-> x.getValue()).toList();
        System.out.println(list);

        // find count of each char
        String q6 = "Missisippi";
        Map<Character,Long> a6 =q6.chars().mapToObj( c-> (char)c).collect(Collectors.groupingBy(c->c,Collectors.counting()));
        System.out.println(a6);

        int q7[] = new int[]{1,2,3,4,5};
        String num = Arrays.stream(q7).mapToObj(i -> String.valueOf(i)).sorted().collect(Collectors.joining(""));
        String denom = Arrays.stream(q7).mapToObj(i -> String.valueOf(i)).sorted(Collections.reverseOrder()).collect(Collectors.joining(""));
        System.out.println(num+"/"+denom);

        //find the sum of unique element:
        int q8[] = new int[]{1,2,3,3,5};
        int sum = Arrays.stream(q8).distinct().sum();
        System.out.println(sum);

        //first non repeated character
        String q9 = "Hello World";
        String a9 = Arrays.stream(q9.split("")).filter(s-> q9.indexOf(s)==q9.lastIndexOf(s)).findFirst().get();
        System.out.println(a9);

        //list of string containing only numbers
        Pattern p = Pattern.compile("[0-9]+");
        String q10[] = new String[]{"123","123vv"};
        List<String> a10 = Arrays.stream(q10).filter( s-> s.matches(p.pattern())).toList();
        System.out.println(a10);

        //multiply first two number
        int q11[] = new int[]{1,2,3,4};
        int a11 = Arrays.stream(q11).limit(2).reduce((a,b) -> a*b).getAsInt();
        System.out.println(a11);

        //group anagram
        String[] q12 = new String[]{"pat","pan","nap"};
        List<List<String>> a12  = Arrays.stream(q12).collect(Collectors.groupingBy( x-> x.chars().mapToObj(c -> (char)c).sorted().collect(Collectors.toList()),Collectors.toList()))
                .entrySet().stream().map(s ->
                {
                    System.out.println(s.getKey());
                    return s.getValue();
                }).toList();
        System.out.println(a12);

        //multiply alternaTIVE
        int a13 = IntStream.range(0,q11.length).filter( i-> i%2!=0).map(x -> q11[x]).reduce(1,(a,b) -> a*b);

        System.out.println(a13);

        // place all zero at begining
        int[] q13 = new int[]{1,0,2,0,5,-1};
        Comparator<Integer> c = (a,b) -> {
            if(a==0 || b==0){
                return a-b;
            }
            return 1;

        };
        List<Integer> a14 = Arrays.stream(q13).boxed().sorted(c).toList();
        System.out.println(a14);

        //remove all alpha numeric
        List<String> q15 = Arrays.asList("123eee","ee345");
        List<String> a15 = q15.stream().map(x -> x.replaceAll("[^0-9]","")).toList();
        System.out.println(a15);

        //calculate avg
        List<Integer> q16 = List.of(1,2,5);
        double avg = q16.stream().mapToDouble(Integer::doubleValue).average().getAsDouble();
        System.out.println(avg);

        //intersection
        List<Integer> l1 = List.of(1,2,3,4);
        List<Integer> l2 = List.of(5,4,6);
        List<Integer> l3 = l1.stream().filter(l2::contains).toList();
        System.out.println(l3);


        List<Emp> emps = new ArrayList<>();
        Emp e1 = new Emp("alice","abc@gmail.com",10);
        Emp e2 = new Emp("alice","abc@yahoo.com",10);
        Emp e3 = new Emp("alice","abc@gmail.com",10);
        emps.add(e1);
        emps.add(e2);
        emps.add(e3);

        //group by mail
        Map<String,List<String>> mapEmp = emps.stream().map(x-> x.getMail().substring(x.getMail().indexOf("@")))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.toList()));
        System.out.println(mapEmp);
        int a = 0;
        int b = 1;
        List<Integer> fib = Stream.iterate(new int[]{0,1},f -> new int[]{f[1],f[1]+f[0]})
                .limit(5).map( d-> d[0]).toList();
        System.out.println(fib);

        Collector<Emp,StringJoiner,String> collectors = Collector.of(
                () -> new StringJoiner(" | "),
                (f,k) -> f.add(k.getName().toUpperCase()),
                StringJoiner::merge,
                StringJoiner::toString);


        // we cannot re use stream

        // reduce(a,b -> a+" " + b).orElse(""); orELSE IF stream is empty
        // map vs flat map

        double avgInc = emps.stream().mapToDouble(Emp::getIncome).average().getAsDouble();
        System.out.println(avgInc);
        //lowest income
        double lowInc = emps.stream().mapToDouble(Emp::getIncome).min().getAsDouble();
        System.out.println(lowInc);

        //lowest income return emp
        Emp lowIncEmp = emps.stream().min((g,h)-> g.income - h.income).get();
        System.out.println(lowIncEmp.getName());

        //convert list to array
        Integer[] array = l1.stream().toArray(Integer[]::new);

        //generate
        Stream<Double> streamD = Stream.generate(Math::random);
        streamD.limit(10).forEach(System.out::println);

        //reduce
        int reduceSum = l1.stream().reduce((b1,b2)-> b1+b2).get();
        int reduceSum2 = l1.stream().reduce(1,(b1,b2)-> b1+b2);
        System.out.println(reduceSum2);

        //print middle char

        String q20 = "travel";
        String mid = IntStream.range(0,q20.length()).filter(x -> q20.length()/2==0? x==q20.length()/2:x==q20.length()/2-1)
                .mapToObj(q20::charAt)
                .collect(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append
                        ).toString();

        System.out.println(mid);

        //boxed to use sort on int

        //peek
        emps.stream().filter(x -> x.getIncome()>=10).peek(y-> y.income=y.getIncome()+1000).toList().forEach(System.out::println);

        //comparing
        emps.stream().sorted(Comparator.comparing(Emp::getName).thenComparing(Emp::getIncome)).toList();

        //max(Map.Entry.ComparingByValue())

        











    }



}


