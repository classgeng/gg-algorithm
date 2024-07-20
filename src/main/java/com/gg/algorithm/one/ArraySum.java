package com.gg.algorithm.one;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * 数组排序 -> 去重
 * 给定一个数组，编写一个函数来计算它的最大N个数与最小N个数的和。你需要对数组进行去重。
 *
 * 说明：
 *        *数组中数字范围[0, 1000]
 *        *最大N个数与最小N个数不能有重叠，如有重叠，输入非法返回-1
 *        *输入非法返回-1
 * 解析：
 * 方法1：先排序（冒泡） -> 再去重（set） -> 再计算
 * 方法2：直接用TreeSet集合排序去重，使用 first()、last() 方法计算前后 n 个数相加
 */
public class ArraySum {

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5, 2, 4, 6, 3, 5, 6};

        dubbleOrder(arr);
        System.out.println("selection sort: " + Arrays.toString(arr));


        System.out.println("selection quchong3: " + quchong3(arr));

        int total = sumMin(5, arr) + sumMax(5, arr);
        System.out.println("total1: " + total);

        System.out.println("total2: " + sum(arr,5));


    }

    public static int sumMin(int min, int[] arr){
        int sum = 0;
        int index = 0;
        while(index < min){
            sum+=arr[index];
            index++;
        }
        return sum;
    }

    public static int sumMax(int max, int[] arr){
        int sum = 0;
        int index = 1;
        while(index <= max){
            sum+=arr[arr.length-index];
            index++;
        }
        return sum;
    }

    /**
     * 冒泡排序
     * @param arr
     */
    public static void dubbleOrder(int[] arr){
        if(null == arr || arr.length == 0){
            return;
        }
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * @param arr
     */
    public static void secletOrder(int[] arr){
        if(null == arr || arr.length == 0){
            return;
        }
        for (int i=0; i<arr.length; i++){
            int min = i;
            for (int j=i+1; j< arr.length; j++){ // 找出第i个数在数组中最小的索引下标
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * set集合去重
     * @param arr
     * @return
     */
    public static int[] quchong(int[] arr){
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<arr.length; i++) {
            set.add(arr[i]);
        }

        int[] newArr = new int[set.size()];
        int i = 0;
        for(int num:set){
            newArr[i] = num;
            i++;
        }
        return newArr;
    }

    /**
     * 双层循环去重
     * @param arr
     * @return
     */
    public static int[] quchong1(int[] arr){
        int[] newArr = new int[arr.length];
        int index = 0;
        for (int i=0; i<arr.length; i++) {
            boolean flag = true;
            for (int j=0; j<i; j++) {
                if(arr[i] == arr[j]){
                    flag = false;
                    break;
                }
            }
            if(flag) {
                newArr[index++] = arr[i];
            }
        }
        return newArr;
    }

    /**
     * lamda表达式去重
     * @param arr
     * @return
     */
    public static int[] quchong2(int[] arr){
        return IntStream.of(arr).distinct().toArray();
    }

    /**
     * TreeSet去重
     * @param arr
     * @return
     */
    public static int sum(int[] arr, int n){
        // 有序，且元素不能重复
        TreeSet<Integer> set = new TreeSet<>();
        for (int num:arr){
            set.add(num);
        }
        System.out.println("TreeSet1: " + Arrays.toString(set.toArray()));
        if(set.size() < 2*n){
            return -1;
        }

        int total = 0;
        for (int i=0; i<n; i++){
            total+=set.first();
            set.remove(set.first());

            total+=set.last();
            set.remove(set.last());
        }
        System.out.println("TreeSet2: " + Arrays.toString(set.toArray()));
        return total;
    }

    /**
     * 双指针去重
     * @param arr
     * @return
     */
    public static int quchong3(int[] arr){
        int index = 0;
        for (int i=1; i<arr.length; i++) {
           if(arr[index] != arr[i]){
               index++;
               arr[index] = arr[i];
           }
        }
        return index+1;
    }


}
