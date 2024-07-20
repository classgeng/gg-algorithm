package com.gg.algorithm.three;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 幼儿园里有一个放倒的圆桶，它是一个线性结构，允许在桶的右边将篮球放入，可以在桶的左边和右边将篮球取出。
 * 每个篮球有单独的编号，老师可以连续放入一个或多个篮球，小朋友可以在桶左边或右边将篮球取出，当桶里只有一个篮球的情况下，必须从左边取出。
 *
 * 如老师按顺序放入1、2、3、4、5 共5个编号的篮球，那么小朋友可以依次取出的编号为“1,2,3,4,5”或者“3,1,2,4,5”编号的篮球，无法取出 “5,1,3,2,4” 编号的篮球
 * 其中“3,1,2,4,5”的取出场景为：连续放入1,2,3号 -> 从右边取出3号 -> 从左边取出1号 -> 从左边取出2号 -> 放入4号 -> 从左边取出4号 -> 放入5号 -> 从左边取出5号，
 * 简单起见，我们以L表示左，R表示右，此时的篮球的依次取出序列为“ RLLLL ”
 */
public class ShootBasket {

    public static void main(String[] args) {
        // 投入篮球编号
        int[] pushList = {1,2,3,4,5};
        // 取出篮球编号
        int[] popList = {3,1,2,4,5};
        // 取出序列(L表示左，R表示右)
        popOrder(pushList, popList);
    }


    /**
     * 输出取出顺序
     * @param pushList  // 入队顺序
     * @param popList   // 出队顺序
     */
    public static void popOrder(int[] pushList, int[] popList){
        StringBuilder popOrder = new StringBuilder();
        // 双端队列
        Deque<Integer> queue = new ArrayDeque<>();
        int index = 0;
        for (int i=0; i<pushList.length; i++){
            queue.offer(pushList[i]);
            while (!queue.isEmpty()){
                if(queue.peek() == popList[index]){
                    //左边取出
                    queue.poll();
                    popOrder.append("L");
                    index++;
                } else if(!queue.isEmpty() && queue.peekLast() == popList[index]){
                    // 右边取出
                    queue.pollLast();
                    popOrder.append("R");
                    index++;
                } else {
                    break;
                }
            }
        }
        if(popOrder.length() == pushList.length){
            System.out.println(popOrder);
        } else {
            System.out.println("NO");
        }

    }

}
