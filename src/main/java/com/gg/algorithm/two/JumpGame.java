package com.gg.algorithm.two;


import java.util.Arrays;

/**
 * 给一个正整数列 nums，一个跳数 jump，及幸存数量 left。运算过程为：从索引为0的位置开始向后跳，中间跳过 J 个数字，命中索引为J+1的数字，
 * 该数被敲出，并从该点起跳，以此类推，直到幸存left个数为止。然后返回幸存数之和。
 *
 * 约束：
 * 1）0是第一个起跳点。
 * 2）起跳点和命中点之间间隔 jump 个数字，已被敲出的数字不计入在内。
 * 3）跳到末尾时无缝从头开始（循环查找），并可以多次循环。
 * 4）若起始时 left>len(nums) 则无需跳数处理过程。
 *
 * nums: 正整数数列，长度范围 [1,10000]
 * jump: 跳数，范围 [1,10000]
 * left: 幸存数量，范围 [0,10000]
 * return: 幸存数之和
 */
public class JumpGame {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int jump = 3;
        int left = 3;
        System.out.println(jump(nums,jump,left));
    }

    /**
     * 计算幸存数之和
     * @param nums 数组
     * @param jump 跳跃间隔
     * @param left 幸存数量
     * @return
     */
    public static int jump(int[]nums, int jump, int left) {
        int len = nums.length;
        if(left >= len){
            return Arrays.stream(nums).sum();
        }
        int removeCount = 0; // 记录跳跃次数，每跳跃一次就移除一个幸存数
        int nextIndex = 1; // 记录下次跳跃的起始位置(移除位置)
        // 记录是否被移除,true移除,false幸存
        boolean[] flag = new boolean[len];
        while(left != len-removeCount){
            removeCount++;

            while (flag[nextIndex]){ //跳过已经移除的
                nextIndex++;
                if(nextIndex >= len){
                    nextIndex = 0;
                }
            }
            nextIndex = (nextIndex + jump) % len; //循环数组下标
            while (flag[nextIndex]){ //跳过已经移除的
                nextIndex++;
                if(nextIndex >= len){
                    nextIndex = 0;
                }
            }
            flag[nextIndex] = true;
        }
        int sum = 0;
        for(int i=0;i<len; i++){
            if(!flag[i]){
                sum += nums[i];
            }
        }
        return sum;
    }


}
