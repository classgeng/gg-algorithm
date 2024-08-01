package com.gg.algorithm.one;

import java.util.Scanner;

/**
 * 单词匹配
 */
public class Words {

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n = in.nextInt();
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = in.next();
        }
        String target = in.next();
        preWord(words, target);
    }

    public static void preWord(String[] words, String target){
        int total = 0;
        int countA = countA(target);
        for (int i = 0; i < words.length; i++) {
            int count = 0;
            char[] ss = words[i].toCharArray();
            for (char cc : ss){
                if(target.contains(String.valueOf(cc))){
                    count++;
                }else if(countA>0){
                    count++;
                    countA--;
                }else{
                    break;
                }
            }
            if(count == ss.length){
                total++;
            }
        }
        System.out.println(total);
    }

    public static int countA(String target){
        int count = 0;
        char[] ss = target.toCharArray();
        for (char cc : ss){
            if(cc == '?'){
                count++;
            }
        }
        return count;
    }

}
