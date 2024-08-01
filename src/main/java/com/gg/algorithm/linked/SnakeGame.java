package com.gg.algorithm.linked;

import java.util.Random;

public class SnakeGame {

    public static void main(String[] args) {
        DeLinkedTable snake1 = createSnake(5);
        DeLinkedTable snake2 = createSnake(5);

        palyGame(snake1,snake2);

    }

    private static void palyGame(DeLinkedTable snake1, DeLinkedTable snake2) {
        int count = 1;
        while(snake1.getSize() > 0 && snake2.getSize() > 0) {
            int r1 = new Random().nextInt(snake1.getSize()) + 1;
            int r2 = new Random().nextInt(snake2.getSize()) + 1;
            eatSnake(snake1,r1);
            eatSnake(snake2,r2);
            System.out.println("第"+count+"局结束：snake1长度还剩：" + snake1.getSize() +", snake2长度还剩："+ snake2.getSize());
            count++;
        }
        if(snake1.getSize() == 0 && snake2.getSize() == 0){
            System.out.println("游戏结束，同归于尽");
        }else {
            String winner = null == snake1.getTopNode() ? "snake2" : "snake1";
            System.out.println("游戏结束，获胜者是：" + winner);
        }
    }

    public static void eatSnake(DeLinkedTable snake, int r) {
        for (int i = 0; i < r; i++) {
            snake.pop();
        }
    }

    public static DeLinkedTable createSnake(int size){
        DeLinkedTable stack = new DeLinkedTable();
        for (int i = 0; i < size; i++) {
            stack.push(i);
        }
        return stack;
    }


}
