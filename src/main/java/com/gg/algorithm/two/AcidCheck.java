package com.gg.algorithm.two;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *为了达到新冠疫情精准防控的需要，为了避免全员核酸检测带来的浪费，需要精准圈定可能被感染的人群。
 * 现在根据传染病流调以及大数据分析，得到了每个人之间在时间、空间上是否存在轨迹的交叉。
 * 现在给定一组确诊人员编号（X1, X2, X3, .... Xn）,在所有人当中，找出哪些人需要进行核酸检测，输出需要进行核酸检测的人数。（注意：确诊病例自身不需要再做核酸检测）
 * 需要进行核酸检测的人，是病毒传播链条上的所有人员，即有可能通过确诊病例所能传播到的所有人。
 * 例如：A是确诊病例，A和B有接触、B和C有接触、C和D有接触、D和E有接触，那么B\C\D\E都是需要进行核酸检测的人。
 */
public class AcidCheck {

    public static void main(String[] args) {
        //构建一个人群，1表示有接触，0表示没接触
        int[] item0 = {1,1,0,1,0};
        int[] item1 = {1,1,0,0,0};
        int[] item2 = {0,0,1,0,1};
        int[] item3 = {1,0,0,1,0};
        int[] item4 = {0,0,1,0,1};
        int[][] map = {item0,item1,item2,item3,item4};

        //确诊人员编号
        List<Integer> qzList = new ArrayList<>();
        qzList.add(1);
        qzList.add(2);

        List<Integer> list = dfs(map, qzList);
        System.out.println("\n需要进行核酸检测的人数:"+list.size()+", 分别是："+list);

    }

    /**
     * 深搜
     * @param map 人群
     * @param qzList 确认人员编号
     * @return
     */
    public static List<Integer> dfs(int[][] map, List<Integer> qzList){
        List<Integer> result = new ArrayList<>();
        boolean[] pass = new boolean[map.length];
        for (int i=0; i<map.length; i++){
            if(!pass[i]){
                dfsDepth(result,map,pass,i);
            }
        }
        result.removeAll(qzList); // 移除已确诊人员编号
        return result;
    }
    //一排一排找
    private static void dfsDepth(List<Integer> result, int[][] map, boolean[] pass, int i) {
        System.out.print(i + " ");
        result.add(i);
        pass[i] = true;
        for (int j=0; j<map.length; j++){
            if(!pass[j] && map[i][j] != 0){
                dfsDepth(result,map,pass,j);
            }
        }
    }


}
