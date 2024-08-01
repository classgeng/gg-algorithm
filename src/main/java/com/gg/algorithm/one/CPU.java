package com.gg.algorithm.one;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * CPU算力
 */
public class CPU {


    public static void main(String[] args) {
        int[] a = {1,1};
        int[] b = {2,2};
        cpu(a,b);
    }

    public static void cpu(int[] a,int[] b){
        int suma = IntStream.of(a).sum();
        int sumb = IntStream.of(b).sum();

        int avg = (suma-sumb)/2;

        List<Integer> list = IntStream.of(b).boxed().collect(Collectors.toList());

        Arrays.sort(a);
        for (int aa : a) {
            int c = aa - avg;
            if(list.contains(c)){
                System.out.println(aa + " " + c);
                break;
            }

        }



    }



}
