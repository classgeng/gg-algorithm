package com.gg.algorithm.one;

/**
 * 字符串分割
 */
public class StringSplit {

    public static void main(String[] args) {
        String str = "Abc";
        char[] cc = str.toCharArray();
        int sCount = 0;
        int mCount = 0;
        for (int i = 0; i < cc.length; i++) {
           if(cc[i] >= 'a' && cc[i] <= 'z') {
               sCount++;
           }else if(cc[i] >= 'A' && cc[i] <= 'Z'){
               mCount++;
           }
        }

        if(sCount>mCount){
            System.out.println(str.toLowerCase());
        }else{
            System.out.println(str.toUpperCase());
        }

    }


}
