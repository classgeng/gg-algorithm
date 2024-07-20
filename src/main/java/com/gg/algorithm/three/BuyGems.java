package com.gg.algorithm.three;


import java.util.Arrays;

/**
 *  橱窗里有一排宝石，不同的宝石对应不同的价格，宝石的价格标记为gems[i],0<=i<n, n = gems.length
 *  宝石可同时出售0个或多个，如果同时出售多个，则要求出售的宝石编号连续；例如客户最大购买宝石个数为m，购买的宝石编号必须为gems[i],gems[i+1]...gems[i+m-1](0<=i<n,m<=n)
 *  假设你当前拥有总面值为value的钱，请问最多能购买到多少个宝石,如无法购买宝石，则返回0.
 */
public class BuyGems {

    public static void main(String[] args) {
        int value = 200;
        int[] gems = {80, 10, 40, 70, 30, 20, 50, 60};
        System.out.println(Arrays.toString(gems));
        quickSort(gems);
        System.out.println(Arrays.toString(gems));
        System.out.println(buyGems(gems,value));
    }


    public static int buyGems(int[] gems, int value){
        if(null == gems || gems.length == 0){
            return 0;
        }
        // 再循环累加
        int total = 0;
        for (int i=0; i<gems.length; i++){
            total+=gems[i];
            if(total == value){
                return i+1;
            } else if (total > value){
                return i;
            }
        }
        return 0;
    }

    /**
     * 冒泡排序
     * @param gems
     */
    public static void dubbleSort(int[] gems){
        for (int i=0; i<gems.length; i++){
            for (int j=0; j<gems.length-i-1; j++){
                if(gems[j] > gems[j+1]){
                    int temp = gems[j+1];
                    gems[j+1] = gems[j];
                    gems[j] = temp;
                }
            }
        }
    }


    public static void quickSort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }

    /**
     * 快速排序
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }
        // 先整个数组排一遍，找出left的位置，左边是比left小的，右边是比left大的
        int p = partition(arr, left, right);
        quickSort(arr,left,p-1); // 继续同样的方法排左边
        quickSort(arr,p+1,right); // 继续同样的方法排右边
    }

    /**
     * 先整个数组排一遍，找出left的位置，左边是比left小的，右边是比left大的
     * @param arr
     * @param start 比较开始位置
     * @param end 比较结束位置
     * @return
     */
    public static int partition(int[] arr, int start, int end){
        int p = arr[start];
        int left = start;
        int temp;
        for (int i=start+1; i<=end; i++){
            if(p >= arr[i]){
                left++; //开始左移
                temp = arr[left];
                arr[left] = arr[i];
                arr[i] = temp;
            }
        }
        arr[start] = arr[left];
        arr[left] = p;
        return left;
    }

}
