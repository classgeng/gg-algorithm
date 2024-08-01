package com.gg.algorithm.two;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Tjsm {

    public static void main(String[] args) {
        int[] t = {10,7,5};
        int[] q = {6,11,8};
        System.out.println(tjsm(t,q));
    }

    public static int tjsm(int[] t, int[] q){
        quickSort(t);
        System.out.println(Arrays.toString(t));
        quickSort(q);
        System.out.println(Arrays.toString(q));

        //双指针
        int tLeft = 0,tRight = t.length-1;
        int qLeft = 0,qRight = q.length-1;
        int sum = 0;
        while (tLeft <= tRight){
            if(t[tRight] > q[qRight]){
                System.out.println(t[tRight] + " > " + q[qRight]);
                sum+=200;
                tRight--;
                qRight--;
            }else if(t[tRight] < q[qRight]){ //最快的马输了，就拿最慢的马跟最快的马比
                sum-=200;
                tLeft++; // 去掉田忌最慢的马
                qRight--; // 去掉齐威王最快的马
            }else{
                if(t[tLeft] > q[qLeft]){
                    System.out.println(t[tLeft] + " > " + q[qLeft]);
                    sum+=200;
                    tLeft++;
                    qLeft++;
                }else if(t[tLeft] < q[qRight]) { //最慢的马输了，就拿最慢的马跟最快的马比
                    sum -= 200;
                    tLeft++; // 去掉田忌最慢的马
                    qRight--; // 去掉齐威王最快的马
                }
            }
        }
        return sum;
    }


    public static void quickSort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }
    public static void quickSort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }
        int mid = mid(arr,left,right);
        quickSort(arr,left,mid-1);
        quickSort(arr,mid+1,right);
    }

    private static int mid(int[] arr, int left, int right) {
        int pValue = arr[left];
        int mid = left;
        int temp;
        for (int i = left+1; i <=right ; i++) {
            if(pValue >= arr[i]) {
                mid++; // 左移
                temp = arr[mid];
                arr[mid] = arr[i];
                arr[i] = temp;
            }
        }
        arr[left] = arr[mid];
        arr[mid] = pValue;
        return mid;
    }



}