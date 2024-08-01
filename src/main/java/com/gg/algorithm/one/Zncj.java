package com.gg.algorithm.one;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 只能成绩
 */
public class Zncj {


    public static void main(String[] args) {
        int[] xk = {3, 2};
        String[] km = {"yuwen","shuxue"};

        // 存储学生姓名、科目、成绩
        Map<String, Map<String,Integer>> map = new HashMap<>();

        Map<String,Integer> fangfang = new HashMap<>();
        fangfang.put("yuwen", 95);
        fangfang.put("shuxue", 90);
        map.put("fangfang",fangfang);

        Map<String,Integer> xiaohua = new HashMap<>();
        xiaohua.put("yuwen", 88);
        xiaohua.put("shuxue", 98);
        map.put("xiaohua",xiaohua);

        Map<String,Integer> minmin = new HashMap<>();
        minmin.put("yuwen", 100);
        minmin.put("shuxue", 82);
        map.put("minmin",minmin);

        String score = "1";

        orderByScore(map,score);


    }


    public static void orderByScore(Map<String, Map<String,Integer>> map, String order){
        Map<String,Integer> result = new TreeMap<>();

        Iterator<Map.Entry<String, Map<String, Integer>>> iter = map.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry<String, Map<String, Integer>> item = iter.next();

            String name = item.getKey();
            int value = 0;

            Map<String, Integer> score = item.getValue();
            if(score.keySet().contains(order)){
                value = score.get(order);
            }else{
                for(int aa : score.values()){
                    value += aa;
                }
            }
            result.put(name,value);
        }
        sort(result);
    }
    public static void sort(Map<String,Integer> map){
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Stack<String> top = new Stack<>();
        for (Map.Entry<String, Integer> item : list) {
            System.out.println(item.getKey() + " -> " +item.getValue());
            top.push(item.getKey());

        }
        while (!top.isEmpty()){
            System.out.print(top.pop() + " ");
        }
    }



}
