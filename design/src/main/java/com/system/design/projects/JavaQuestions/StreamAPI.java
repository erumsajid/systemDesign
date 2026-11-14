package com.system.design.projects.JavaQuestions;



import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String args[]){
        StreamAPI.streamAPIQuestion();
    }
    public static void streamAPIQuestion(){
        //remove all alpha numeric question
        List<String> l = Arrays.asList("abc123","123def","123");
        Pattern pattern = Pattern.compile("[^0-9]");
        l.stream().map(x -> pattern.matcher(x).replaceAll("")).collect(Collectors.toList());

        //print string that contains only digits

        l.stream().filter(x -> x.matches("[0-9]+")).forEach(System.out::println);

        //make list string to upper case
        List<String> a1 = l.stream().map(String:: toUpperCase).collect(Collectors.toList());
        System.out.println(a1);

        //calculate the average
        List<Integer> e2 = Arrays.asList(1,2,3,4);
        double a2 = e2.stream().mapToDouble(Integer::doubleValue).average().getAsDouble();
        System.out.println(a2);

        //intersect two lists
        List<Integer> e3 = Arrays.asList(1,2,3);
        List<Integer> e4 = Arrays.asList(6,5,3);

        List<Integer> a3 = e3.stream().filter(e4::contains).toList();
        System.out.println(a3);

        //
        Emp e5 = new Emp("alice","alice@gmail.com",10);
        Emp e6 = new Emp("john","john@google.com",20);

        List<Emp> e7 = new ArrayList<>();
        e7.add(e5);
        e7.add(e6);
        Function<Emp,String> e1 = x -> x.email.substring(x.email.indexOf("@"));
        Map<String,List<String>> a8 = e7.stream().collect(Collectors.groupingBy(e1,Collectors.mapping(Emp::getName,Collectors.toList())));

        System.out.println(a8);


       //print fibonacci by stream
        List<Integer> a9 = Stream.iterate(new int[]{0,1}, f-> new int[]{f[1],f[0]+f[1]})
                .map(f -> f[0]).limit(10)
                .collect(Collectors.toList());

        System.out.println(a9);

        //list of their square
        List<Integer> a10 = e2.stream().map(x -> x*x).toList();
        System.out.println(a10);

        //combine name with | and upercase
        String a11 = e7.stream().map(x -> x.name.toUpperCase()).collect(Collectors.joining("|"));
        System.out.println(a11);

        //Group list of strings by their first character and count the number of strings
        List<String> e12 = Arrays.asList("abc","edf","apple");
        Function<String,String> f1 = x -> x.charAt(0)+"";
        Map<String,Long> a12 = e12.stream().collect(Collectors.groupingBy((x->x.charAt(0)+""),Collectors.counting()));
        System.out.println(a12);

        //multiply
        Optional<Integer> a13 = e2.stream().reduce((a, b) -> a*b);
        System.out.println(a13);

        //same stream we cannot use , use supplier to create stream
        Supplier<Stream<Integer>> s = () -> e2.stream();
        System.out.println(s.get().max(Comparator.comparing(x -> x)));
        System.out.println(s.get().min(Comparator.comparing(x -> x)));

        String ans = l.stream().reduce((s1,s2) -> s1 + " " + s2).get();
        System.out.println(ans);

        //print filtered emp
        List<Emp> a14 = e7.stream().filter(a -> a.income<=10).toList();
        System.out.println(a14);

        List<Emp> a15  = e7.stream().map(x ->
        {
            x.income = x.income * 10;
            return x;
        }).toList();
        System.out.println(a15);

        double a16 = e7.stream().collect(Collectors.averagingInt(Emp::getIncome));

        System.out.println(a16);

        List<Integer> a17 = Stream.iterate(1,x->x+1).limit(10).toList();

        System.out.println(a17);

        //group by with average
        Map<String,Double> a18 = e7.stream().collect(Collectors.groupingBy(Emp::getName,Collectors.averagingInt(Emp::getIncome)));

        //convert list to array
        Integer[] a19 = e3.stream().toArray(Integer[]::new);

        //generate infinite
        Stream<Double> randomNum = Stream.generate(Math::random);
        List<Double> a20 = randomNum.limit(10).toList();
        System.out.println(a20);

        //iterate : create infinite stream by iteration over a function
        Stream<Integer> num = Stream.iterate(0,x->x+2).limit(5);

        //of
        Stream<Integer> stream = Stream.of(10,20);


        //concat :
        Stream<Integer> s1 = Stream.of(1,2,3);
        Stream<Integer> s2 = Stream.of(5,6,7);
        Stream.concat(s1,s2).forEach(System.out::println);

        //reduce -> reduce the element to single value

        //print middle character
        String string = "travel";
        String midChar =  IntStream.range(0,string.length())
                .filter(x -> string.length()%2==0? (x==string.length()/2 || x==string.length()/2-1) : x==string.length()/2)
                .mapToObj(x -> string.charAt(x)+"")
                .collect(Collectors.joining());

        System.out.println(midChar);

        //filter num that start with 1
        int nums[] = new int[]{11,22,123,1};
        List<Integer> RES = Arrays.stream(nums).filter(x -> String.valueOf(x).startsWith("1"))
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(RES);

        //print emp with updated salary

        List<Emp> a21  = e7.stream().peek(x -> x.income = x.income * 10).toList();
        System.out.println(a21);

        e7.stream().sorted(Comparator.comparing(Emp::getName).thenComparing(Emp::getIncome)).forEach(System.out::println);

        //count xo
        String e22 = "xoxoabcxo";
        long a22 = IntStream.range(0,e22.length()-1).filter(st-> e22.substring(st,st+2).equals("xo")).count();
        System.out.println(a22);


        String mail = e7.stream().collect(Collectors.groupingBy(Emp::getMail,Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue())
                .get().getKey();

        //sort by time
        //we can do this by then comparing
        List<String> logs = Arrays.asList("14:30:3:server started",
                "14:30:1:user logged in",
                "14:30:0:booting up.....",
                "14:29:3:db connect",
                "14:32:4:user logged out");
        logs.stream().sorted((log1,log2) -> {

             String[] l1 = log1.split(":",4);
             int time = (Integer.valueOf(l1[0])*100 + Integer.valueOf(l1[1]))*100 + Integer.valueOf(l1[2]);

            String[] l2 = log2.split(":",4);
            int time2 = (Integer.valueOf(l2[0])*100 + Integer.valueOf(l2[1]))*100 + Integer.valueOf(l2[2]);

            return time - time2;



        }).map(x -> x.split(":",4)[3]).forEach(System.out::println);


        String maxFreq = "javadeveloper";
        char maxChar = IntStream.range(0,maxFreq.length()-1).mapToObj(Integer::valueOf).collect(Collectors.groupingBy(x -> maxFreq.charAt(x),Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        System.out.println(maxChar);

        Map<Character,Long> mf = maxFreq.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(x->x,Collectors.counting()));

        System.out.println(mf);

        List<String> fruits = Arrays.asList("orange","banana","kiwi","kiwi");
        //using toMap
        Map<String,Integer> flen = fruits.stream().collect(
                Collectors.toMap(x->x
                        ,String::length,
                        (x,y) -> x //merging if duplicate key
                ));
        System.out.println(flen);

        //palindrome
        String pal = "madam";
        boolean isPall = IntStream.range(0,pal.length()/2).allMatch(x-> pal.charAt(x)==pal.charAt(pal.length()-1-x));
    }

}
class Emp{
    String name;
    String email;
    int income;
    Emp(String name,String email,int income){
        this.email = email;
        this.name = name;
        this.income = income;
    }
    public String getName(){
        return name;
    }
    public int getIncome(){
        return income;
    }
    public String getMail(){
        return email;
    }
}

