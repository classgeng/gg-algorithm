package com.gg.algorithm;

/**
 * 找数字
 */
public class FindNum {

    public static void main(String[] args) {
        int num = (int) Math.pow(10, 9);
        //int num = 7;
        System.out.println(findMinNum(num));
    }


    public static int findMinNum(int num){
        int count1 = binaryCount(num);
        int minNum = num + 1;
        int count2 = binaryCount(minNum);
        while (count1 != count2) {
            minNum++;
            count2 = binaryCount(minNum);
        }
        return minNum;
    }

    public static int binaryCount(int num) {
        int count = 0;
        String binStr = Integer.toBinaryString(num); //十进制转出二进制字符串
        char[] ss = binStr.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if(ss[i] == '1'){
                count++;
            }
        }
        return count;
    }

}
