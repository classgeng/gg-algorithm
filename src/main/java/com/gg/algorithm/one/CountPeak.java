package com.gg.algorithm.one;

/**
 * 攀登者喜欢寻找各种地图，并且尝试攀登到最高的山峰。
 * 地图表示为一维数组，数组的索引代表水平位置，数组的高度代表相对海拔高度。其中数组元素0代表地面。
 * 例如[0,1,2,4,3,1,0,0,1,2,3,1,2,1,0], 代表如下图所示的地图，地图中有两个山脉位置分别为 1,2,3,4,5和8,9,10,11,12,13，最高峰高度分别为 4,3。最高峰位置分别为3,10。
 * 一个山脉可能有多座山峰(高度大于相邻位置的高度，或在地图边界且高度大于相邻的高度)。
 *                 4
 *
 *               +---+
 *               |   |
 *               |   | 3                       3
 *               |   |
 *               |   +---+                   -----
 *               |       |                   |   |
 *             2 |       |                 2 |   |     2
 *               |       |                   |   |
 *           +---+       |               ----+   |   +---+
 *           |           |               |       |   |   |
 *         1 |           | 1           1 |       | 1 |   | 1
 *           |           |               |       |   |   |
 *       +---+           +---+       +---+       +---+   +---+
 *       |                   |       |                       |
 *     0 |                   | 0   0 |                       | 0
 *       |                   |       |                       |
 *   +---+                   +-------+                       +---+
 *
 *     0   1   2   3   4   5   6   7   8   9  10  11  12  13  14
 * 登山者想要知道一张地图中有多少座山峰
 */
public class CountPeak {

    public static void main(String[] args) {
        int[] map = {0,1,2,4,3,1,0,0,1,2,3,1,2,1,0};
        System.out.println(countPeak(map));

    }

    public static int countPeak(int[] arr){
        int count = 0;
        for (int i=1; i<arr.length-1; i++){
            int curr = arr[i];
            if (curr > arr[i-1] && curr > arr[i+1]) {
                count++;
            }
        }

        //计算边界
        if(arr[0] > arr[1]){
            count++;
        }
        if(arr[arr.length-1] > arr[arr.length-2]){
            count++;
        }
        return count;
    }


}
