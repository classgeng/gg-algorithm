package com.gg.algorithm;

import java.util.Arrays;

/**
 * 找座位
 */
public class FindSit {

    public static void main(String[] args) {
        int[] arr = {1,0,0,0,0,0,1};
        System.out.println(maxSit(arr));
        System.out.println(Arrays.toString(arr));
    }

    public static int maxSit(int[] arr){
        int len = arr.length;
        if(len < 1 && len > 10000){
            return 0;
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            if(arr[i] == 0 && arr[i-1] == 0 && arr[i+1] == 0){
                arr[i] = 1; //占用
                max++;
            }
        }
        return max;
    }

}
