package com.gg.algorithm.one;

/**
 * 幸运数字
 */
public class Xysz {

    public static void main(String[] args) {
        int k = 10;
        int n = 2;
        int m = 4;
        jzConvert(k,n,m);

    }


    public static void jzConvert(int k, int n, int m){
        int count = 0;
        while(k != 0) {
            int yu = k % m;
            if(yu == n){
                count++;
            }
            k = k/m;
        }
        System.out.println(count);

    }
}
