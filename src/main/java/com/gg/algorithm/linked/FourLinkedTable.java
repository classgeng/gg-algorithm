package com.gg.algorithm.linked;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 四向链表类
 */
@Data
@NoArgsConstructor
public class FourLinkedTable {


    public static void main(String[] args) {
        FourLinkedNode<Integer>  node = crateFourLinkedTable(4);
        printNode(node);
    }

    /**
     * 创建一个N维四项链表
     * @param n 维度
     * @return
     */
    private static FourLinkedNode<Integer> crateFourLinkedTable(int n){
        if(n < 1){
            return null;
        }
        //头结点
        FourLinkedNode<Integer> headNode = new FourLinkedNode<>(1);

        // 记录第一排当前节点的left节点
        FourLinkedNode<Integer> rowLeftNode = headNode;
        for (int i = 2; i <= n; i++) {
            //第一排当前节点
            FourLinkedNode<Integer> currRowNode = new FourLinkedNode<>(i);
            rowLeftNode.setRight(currRowNode);
            currRowNode.setLeft(rowLeftNode);
            rowLeftNode = currRowNode; //记录下一个节点的left节点
        }

        // 剩下排（从第2排开始）
        FourLinkedNode<Integer> rowUpNode = headNode; //记录下一排的up节点
        for (int r = 2; r <= n; r++) {
            //当前行的第一个节点
            FourLinkedNode<Integer> currRowNode = new FourLinkedNode<>((r-1)*n+1);
            rowUpNode.setDown(currRowNode);
            currRowNode.setUp(rowUpNode);
            //当前行的up节点指向下一列
            rowUpNode = rowUpNode.getRight();
            //记录下一行的up节点
            FourLinkedNode<Integer> nextRowNode = currRowNode;
            for (int c = 2; c <= n; c++) {
                //当前行的第2列节点开始
                FourLinkedNode<Integer> currColNode = new FourLinkedNode<>((r-1)*n+c);
                currRowNode.setRight(currColNode);
                currColNode.setLeft(currRowNode);
                if(null != rowUpNode){
                    rowUpNode.setDown(currColNode);
                    currColNode.setUp(rowUpNode);
                    rowUpNode = rowUpNode.getRight(); //记录下一个col节点的up节点
                }
                currRowNode = currColNode; //记录下一个col节点的left节点
            }
            rowUpNode = nextRowNode; //记录下一行的up节点
        }
        return headNode;
    }

    public static void printNode(FourLinkedNode<Integer>  fourLinkedNode){
        FourLinkedNode<Integer>  row = fourLinkedNode;
        while(null != row){
            System.out.print(row.getValue() + " ");
            FourLinkedNode<Integer>  col = row.getRight();
            while(null != col){
                System.out.print(col.getValue() + " ");
                col = col.getRight(); //下一列
            }
            System.out.println();
            row = row.getDown(); //下一行
        }
    }

    @Data
    @NoArgsConstructor
    static class FourLinkedNode<T> {

        private T value;
        private FourLinkedNode<T> up;
        private FourLinkedNode<T> down;
        private FourLinkedNode<T> left;
        private FourLinkedNode<T> right;

        public FourLinkedNode(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "FourLinkedNode{" +
                    "value=" + value +
                    '}';
        }
    }

}
