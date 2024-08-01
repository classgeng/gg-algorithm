package com.gg.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {40, 10, 30, 50, 60, 20};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int p = partition(arr,start,end);
        //左边排序
        quickSort(arr,start,p-1);
        //右边排序
        quickSort(arr,p+1,end);
    }
    //一次排序，同时找出中心位置，左边是小的，右边是大的
    public static int partition(int[] arr, int start, int end){
        int pValue = arr[start];
        int left = start;
        int temp;
        for (int i = start+1; i<=end; i++){
            if(pValue >= arr[i]){
                left++;// 开始左移
                temp = arr[left];
                arr[left] = arr[i];
                arr[i] = temp;
            }
        }
        arr[start] = arr[left];
        arr[left] = pValue;
        return left;
    }

}
