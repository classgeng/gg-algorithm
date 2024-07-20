package com.gg.algorithm.three;

import java.util.*;

/**
 * 石头剪刀布游戏有3种出拳形状：石头、剪刀、布。 分别用字母 A,B,C表示。
 *
 * 游戏规则：
 *
 * 1）出拳形状之间的胜负规则如下：A> B；B> C；C> A
 *
 * “>” 左边一个字母，表示相对优势形状。 右边一个字母，表示相对劣势形状。
 *
 * 2) 当本场次中有且仅有一种出拳形状优于其它出拳形状，则该形状的玩家是胜利者。 否则认为是c。
 *   例如1 三个玩家出拳分别是 A,B,C。由于出现三方优势循环（即没有任何一方优于其它出拳者），判断为平局。
 *   例如2 三个玩家，出拳分别是 A,B。出拳A的获胜。
 *   例如3   三个玩家，出拳全部是 A。 判为平局
 * 3）当发生平局，没有赢家。有多个胜利者时，同为赢家。
 */
public class StjdbGame {

    public static void main(String[] args) {
        stjdb('A','B','A');
    }

    public static void stjdb(char player1, char player2, char player3){
        if(player1 == player2 && player2 == player3){
            System.out.println("平局");
            return;
        }
        if(player1 != player2 && player2 != player3 && player1 != player3){
            System.out.println("平局");
            return;
        }
        List<String> winners = new ArrayList<>();
        //玩家1获胜情况
        if ((player1 == 'A' && (player2 == 'A' || player2 == 'B') && (player3 == 'A' || player3 == 'B')) ||
                (player1 == 'B' && (player2 == 'B' || player2 == 'C') && (player3 == 'C' || player3 == 'B')) ||
                (player1 == 'C' && (player2 == 'A' || player2 == 'C') && (player3 == 'C' || player3 == 'A'))) {
            winners.add("玩家1");
        }
        //玩家2获胜情况
        if ((player2 == 'A' && (player1 == 'A' || player1 == 'B') && (player3 == 'A' || player3 == 'B')) ||
                (player2 == 'B' && (player1 == 'B' || player1 == 'C') && (player3 == 'C' || player3 == 'B')) ||
                (player2 == 'C' && (player1 == 'A' || player1 == 'C') && (player3 == 'C' || player3 == 'A'))) {
            winners.add("玩家2");
        }
        //玩家3获胜情况
        if ((player3 == 'A' && (player2 == 'A' || player2 == 'B') && (player1 == 'A' || player1== 'B')) ||
                (player3 == 'B' && (player2 == 'B' || player2 == 'C') && (player1 == 'C' || player1 == 'B')) ||
                (player3 == 'C' && (player2 == 'A' || player2 == 'C') && (player1 == 'C' || player1 == 'A'))) {
            winners.add("玩家3");
        }
        if(winners.isEmpty()){
            System.out.println("平局");
        }else {
            System.out.println("获胜者是：" + winners);
        }

    }





}
