package com.gg.algorithm.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 热内存排序输出
 */
public class MemoryLR {


    public static void main(String[] args) {
        int pageSize = 5;
        int[] page = {1,2,3,4,5};
        int t = 3;

        Arrays.sort(page);
        System.out.println(Arrays.toString(page));

        List<Integer> res = new ArrayList<>();

        int count = 1;
        for (int i = 0; i < page.length-1; i++) {
            if(page[i] == page[i+1]){
                count++;
                if(count >= t){
                    res.add(page[i]);
                }
            }else{
                count = 1;
            }
        }

        System.out.println(res.size());
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }

    }


}
