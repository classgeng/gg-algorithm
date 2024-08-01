package com.gg.algorithm.two;

import javafx.scene.chart.ValueAxis;

import java.util.*;

/**
 * 简易内存池
 */
public class MemoryPool {

    private static Map<Integer,Integer> memory = new HashMap<>();
    private static final int MAX = 100;

    public static void main(String[] args) {
        int n = 6;
        String[] cmds = new String[n];
        cmds[0] = "REQUEST=20";
        cmds[1] = "REQUEST=30";
        cmds[2] = "RELEASE=0";
        cmds[3] = "REQUEST=30";
        cmds[4] = "REQUEST=10";
        cmds[5] = "REQUEST=10";

        memoryManager(n,cmds);
    }


    public static void memoryManager(int n, String[] cmds) {
        for (int i = 0; i < cmds.length; i++) {
            String[] cmd = cmds[i].split("=");
            int value = Integer.parseInt(cmd[1]);
            if(cmd[0].equals("REQUEST")){
                if(value > MAX || value<=0){
                    System.out.println("ERROR");
                    return;
                }
                request(value);
            } else if(cmd[0].equals("RELEASE")){
                memory.remove(value);
            }else{
                System.out.println("非法输入！");
            }
        }

    }
    public static void request(int value){
        int preHeadAddress = 0;
        if(memory.isEmpty()){
            memory.put(0,value);
        }else {
            List<Integer> listKey = new ArrayList<>(memory.keySet());
            for (Integer headAddress : listKey) {
                if(headAddress-preHeadAddress >= value){
                    memory.put(preHeadAddress, preHeadAddress+value);
                }else {
                    preHeadAddress = memory.get(headAddress);
                }
            }

        }
        if(MAX-preHeadAddress >= value){
            memory.put(preHeadAddress,preHeadAddress+value);
            System.out.println(preHeadAddress);
        }else{
            System.out.println("内存已满！");
        }




    }



}
