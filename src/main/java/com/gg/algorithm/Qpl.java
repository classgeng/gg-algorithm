package com.gg.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列-回溯
 * dfs
 */
public class Qpl {

    public static void main(String[] args) {
        String[] nums = {"a","b","a"};
        List<List<String>> res = qpl(nums);
        System.out.println(res);
    }

    public static List<List<String>> qpl(String[] nums){
        if(null == nums || nums.length == 0){
            return null;
        }
        Arrays.sort(nums); //排序
        List<List<String>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        callback(nums,res,used,new ArrayList<>());
        return res;
    }
    public static void callback(String[] nums, List<List<String>> res, boolean[] used, List<String> curr){
        if(nums.length == curr.size()){
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(i>0 && nums[i-1]==nums[i] && !used[i-1]){
                continue;
            }
            if(!used[i]) {
                curr.add(nums[i]);
                used[i] = true;

                callback(nums, res, used, curr);
                curr.remove(curr.size() - 1); // 回溯
                used[i] = false;
            }
        }
    }

}
