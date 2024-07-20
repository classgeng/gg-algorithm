package com.gg.algorithm.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 在学校中，N个小朋友站成一队， 第i个小朋友的身高为height[i]，
 * 第i个小朋友可以看到的第一个比自己身高更高的小朋友j，那么j是i的好朋友(要求j > i)。
 * 请重新生成一个列表，对应位置的输出是每个小朋友的好朋友位置，如果没有看到好朋友，请在该位置用0代替。
 * 小朋友人数范围是 [0, 40000]。
 *
 * 解析：
 * 使用stack找，没找到朋友的放入栈中，直到找到之后就找下一个
 */
public class FindFriends {

    public static void main(String[] args) {
        int[] height = {10, 7, 8, 9, 1, 5, 2, 4, 6, 3};
        List<String> friends = findFriends(height);
        friends.forEach(item -> System.out.println(item));
    }

    public static List<String> findFriends(int[] height){
        List<String> friends = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<height.length; i++){
            while (!stack.isEmpty() && height[stack.peek()] < height[i]){
                //找到好朋友位置，并记录好朋友位置
                friends.add("i:"+stack.peek()+"-"+height[stack.pop()] + ",  j:"+i+"-"+height[i]);
            }
            stack.push(i); // 将当前小朋友i入栈，继续找朋友
        }
        return friends;
    }


}
