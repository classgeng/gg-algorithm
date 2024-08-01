package com.gg.algorithm.one;

import java.util.*;

/**
 * 字符串中连续字母长度
 */
public class StringLong {

    public static void main(String[] args) {
        maxStrLen("AABAAA",2);
    }

    public static void maxStrLen(String str, int k){
        Map<Character,Integer> map = new HashMap<>();
        char[] ss = str.toCharArray();
        int left = 0, right = 1; //双指针
        while (right < ss.length){
            if(ss[left] != ss[right]){
               int len = right - left;
               if(!map.containsKey(ss[left]) || len>map.get(ss[left])){
                   map.put(ss[left], len);
               }
               left = right;
            }
            right++;
            if(right == ss.length){ //考虑最后一次字符串长度
                int len = right - left;
                if(!map.containsKey(ss[left]) || len>map.get(ss[left])){
                    map.put(ss[left], len);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        map.values().forEach(item -> list.add(item));
        Collections.sort(list);
        System.out.println(list);
        System.out.println(list.get(list.size() - k));
    }

}
