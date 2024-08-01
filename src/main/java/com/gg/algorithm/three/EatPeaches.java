package com.gg.algorithm.three;

/**
 * 二分查找
 *
 *孙悟空爱吃蟠桃，有一天趁着蟠桃园守卫不在来偷吃。已知蟠桃园有N颗桃树，每颗树上都有桃子，守卫将在H小时后回来。
 *
 * 孙悟空可以决定他吃蟠桃的速度K（个/小时），每个小时选一颗桃树，并从树上吃掉K个，如果树上的桃子少于K个，则全部吃掉，并且这一小时剩余的时间里不再吃桃。
 *
 * 孙悟空喜欢慢慢吃，但又想在守卫回来前吃完桃子。
 *
 * 请返回孙悟空可以在H小时内吃掉所有桃子的最小速度K（K为整数）。如果以任何速度都吃不完所有桃子，则返回0。
 */
public class EatPeaches {

    public static void main(String[] args) {
        int[] peaches = {2,3,4,5};
        int h = 4;
        int k = minSpeedK(peaches, h);
        System.out.println("孙悟空可以在 "+ h +" 小时内吃掉所有桃子的最小速度K为（个/小时）：" + k);
    }


    /**
     * 二分查找-最小速度
     * @param peaches 桃树数量
     * @param h 守卫h小时后回来
     * @return
     */
    public static int minSpeedK(int[] peaches, int h){
        if(peaches == null || peaches.length > h){
            return 0;
        }
        int leftK = 1, rightK = 1000000000;
        while (leftK <= rightK){
            int k = (leftK + rightK) / 2;
            if(eatPeaches(peaches, h, k)){
                rightK = k - 1;
            } else {
                leftK = k + 1;
            }
        }
        return leftK;
    }
    /**
     * 以速度k能否吃完全部桃子
     * @param k 吃桃速度
     * @return
     */
    public static boolean eatPeaches(int[] peaches, int h, int k){
        int time = 0;
        for (int i = 0; i < peaches.length; i++){
            int t1 = peaches[i] / k;
            int t2 = peaches[i] % k > 0 ? 1 : 0;
            time += t1 + t2;
            if (time > h){
                return false;
            }
        }
        return true;
    }

}
