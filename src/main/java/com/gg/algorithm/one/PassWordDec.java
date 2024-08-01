package com.gg.algorithm.one;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 密码解密
 */
public class PassWordDec {

    public static void main(String[] args) {

        String str = "20*19*20*1233";

        Map<String, String> jzMap = buildJtoZMap();
        System.out.println(jzMap);
        Iterator<Map.Entry<String, String>> iter = jzMap.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry<String, String> entry = iter.next();
            str = str.replace(entry.getKey(),entry.getValue());
        }
        Map<String, String> aiMap = buildAtoIMap();
        Iterator<Map.Entry<String, String>> iter1 = aiMap.entrySet().iterator();
        while (iter1.hasNext()){
            Map.Entry<String, String> entry = iter1.next();
            str = str.replace(entry.getKey(),entry.getValue());
        }

        System.out.println(str);
    }

    public static Map<String,String> buildJtoZMap(){
        Map<String,String> map = new HashMap<>();
        char cc = 'j';
        int start = 10;
        int end = 26;
        while (start <= end) {
            map.put(start+"*", String.valueOf(cc));
            start++;
            cc++;
        }
        return map;
    }

    public static Map<String,String> buildAtoIMap(){
        Map<String,String> map = new HashMap<>();
        char cc = 'a';
        int start = 1;
        int end = 9;
        while (start <= end) {
            map.put(start+"", String.valueOf(cc));
            start++;
            cc++;
        }
        return map;
    }


}
