package com.gg.algorithm;

/**
 * 二分查找
 */
public class MidSelect {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        int num = 9;
        int index = midSelectIndex(nums, num);
        System.out.println(nums[index] + " -> " + index);
    }

    /**
     * 二分查找-必须要排序后的
     * @param nums
     * @param num
     * @return
     */
    public static int midSelectIndex(int[] nums, int num){
        int left = 0, right = nums.length;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] > num){
                right = mid - 1; //右边索引 left -> mid-1
            }else if (nums[mid] < num) {
                left = mid + 1; //左边索引 mid+1 -> right
            }else{
                return mid;
            }
        }
        return -1;
    }

}
