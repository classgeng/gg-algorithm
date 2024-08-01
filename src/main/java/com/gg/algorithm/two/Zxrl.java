package com.gg.algorithm.two;

/**
 * 最小人力
 */
public class Zxrl {

    public static void main(String[] args) {
        int m = 3;
        int[] x = {1,2,10};

        System.out.println(minR(m,x));

    }


    public static int minR(int m, int[] x){
        int leftR = x[x.length-1], rightR = (int)1e9;
        while(leftR < rightR) {
            int r = (leftR + rightR) / 2;
            if (check(m, x, r)) {  //r人力可以完成，贪心减少人力
                rightR = r - 1;
            } else { //r人力完成不了，添加人力
                leftR = r + 1;
            }
        }
        return leftR;
    }
    /**
     * 是否满足需求-枚举方式
     * @param m 时间月份
     * @param x 需求
     * @param r 人力
     * @return
     */
    public static boolean check(int m, int[] x, int r){
        int left = 0, right = x.length-1;
        int mCount = 0;
        while (left <= right) {
            if (x[left] + x[right] > r) {
                right--; //1个月只能完成一个最大任务，减掉一个大需求
            } else {  //否则，1个月可以完成2个任务，一个最多可以完成2个任务
                left++;
                right--;
            }
            mCount++;
        }
        return mCount <= m;
    }

}
