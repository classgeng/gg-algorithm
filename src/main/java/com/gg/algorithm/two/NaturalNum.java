package com.gg.algorithm.two;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个整数可以由连续的自然数之和来表示。
 * 给定一个整数，计算该整数有几种连续自然数之和的表达式，且打印出每种表达式。
 */
public class NaturalNum {

    public static void main(String[] args) {
        int num = 29;
        List<List<Integer>> list = etlList(num);
        System.out.println("整数:" + num + ", 可以表示为以下几种连续自然数之和：");
        list.forEach(item -> System.out.println(item));
    }


    public static List<List<Integer>> etlList(int num){
        List<List<Integer>> result = new ArrayList<>();
        for (int i=1; i<=num/2; i++){
            int sum =0;
            List<Integer> item = new ArrayList<>();
            for(int n=i; n<num; n++){
                sum+=n;
                item.add(n);
                if(sum == num){
                    result.add(item);
                    break;
                }else if (sum > num){
                    break;
                }
            }
        }
        return result;
    }
























    public static List<List<Integer>> numExpression(int num){
        List<List<Integer>> list = new ArrayList<>();
        for(int i=1; i<= num/2; i++){
            int sum = 0;
            List<Integer> item = new ArrayList<>();
            for(int n=i; n<num; n++){
                sum+=n;
                item.add(n);
                if(sum == num){
                    list.add(item);
                    break;
                }else if(sum > num){
                    break;
                }
            }
        }
        return list;
    }


    public static List<List<Integer>> findConsecutiveSums(int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int start = 1; start <= target / 2; start++) {
            int sum = 0;
            List<Integer> sequence = new ArrayList<>();
            for (int i = start; ; i++) {
                sum += i;
                sequence.add(i);
                if (sum == target) {
                    result.add(new ArrayList<>(sequence));
                    break;
                } else if (sum > target) {
                    break;
                }
            }
        }
        return result;
    }

}
