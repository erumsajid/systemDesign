package com.system.design.projects.JavaQuestions;

import java.util.Arrays;

public class Epam {

    public static void common(){
        int arr1[] = new int[]{1,2,3,4,5,6,7,8};
        int arr2[] = new int[]{2,4,6,8};

        Arrays.stream(arr1).forEach( a -> {
            int res[] = Arrays.stream(arr2).filter( b -> b==a).toArray();
            if(res.length>=1){
                System.out.println(a);
            }
        });


    }
}
