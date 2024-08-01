package com.gg.algorithm.test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 二叉树-带父节点
 */
public class BinaryTree {

    public static TreeNode<Integer> buildFullThreeTree(int deep, int value, TreeNode<Integer> parentNode){
        if(deep < 1){
            return null;
        }
        TreeNode<Integer> tree = new TreeNode<>(value,parentNode);
        tree.setLeftNode(buildFullThreeTree(deep-1,2*value,tree));
        tree.setRightNode(buildFullThreeTree(deep-1,2*value+1,tree));
        return tree;
    }

    public static TreeNode<Integer> buildFullThreeTree(int deep){
        if(deep < 1){
            return null;
        }
        TreeNode<Integer> tree = new TreeNode<>(1);
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(tree);
        for (int i = 2; i <= Math.pow(2, deep - 1); i++) {
            //父节点
            TreeNode<Integer> parentNode = queue.poll();
            //创建左节点
            TreeNode<Integer> lNode = new TreeNode<>(2*(i-1), parentNode);
            parentNode.setLeftNode(lNode);
            queue.add(lNode);
            //创建右节点
            TreeNode<Integer> rNode = new TreeNode<>(2*(i-1)+1, parentNode);
            parentNode.setRightNode(rNode);
            queue.add(rNode);
        }
        return tree;
    }
    public static TreeNode<Integer> buildFullTree(int deep, int value){
        if(deep < 1){
            return null;
        }
        TreeNode<Integer> tree = new TreeNode<>(value);
        tree.setLeftNode(buildFullTree(deep-1,2*value));
        tree.setRightNode(buildFullTree(deep-1,2*value+1));
        return tree;
    }

    public static TreeNode<Integer> buildFullTree(int deep){
        if(deep < 1){
            return null;
        }
        TreeNode<Integer> tree = new TreeNode<>(1);

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(tree);

        for (int i = 2; i <= Math.pow(2, deep - 1); i++) {
            TreeNode<Integer> parentNode = queue.poll();
            //创建左节点
            TreeNode<Integer> lNode = new TreeNode<>(2*(i-1));
            parentNode.setLeftNode(lNode);
            queue.add(lNode);
            //创建右节点
            TreeNode<Integer> rNode = new TreeNode<>(2*(i-1)+1);
            parentNode.setRightNode(rNode);
            queue.add(rNode);
        }
        return tree;
    }

    /**
     * 二叉树遍历-递归
     * 前序（根左右）、中序（左根右）、后序（左右根）
     * @param tree
     */
    public static <T> void printTree(TreeNode<T> tree){
        if(null == tree) {
            return;
        }
        System.out.print(tree.getValue() + " ");
        printTree(tree.getLeftNode());
        //System.out.print(tree.value + " ");
        printTree(tree.getRightNode());
        //System.out.print(tree.getValue() + " ");
    }


    /**
     * 二叉树遍历-递归
     * 前序（根左右）、中序（左根右）、后序（左右根）
     * @param tree
     */
    public static <T> void printByTree(TreeNode<T> tree, int count){
        for (int i = 0; i < count; i++) {
            printTree(tree);
            System.out.println();
        }
    }


    public static <T> void printLevelTree(TreeNode<T> tree) {
        if(null == tree) {
            return;
        }
        Queue<TreeNode<T>> queue = new ArrayDeque<>();
        queue.offer(tree);
        while(!queue.isEmpty()){
            TreeNode<T> currNode = queue.poll();
            System.out.print(currNode.getValue() + " ");
            if(null != currNode.getLeftNode()) {
                queue.offer(currNode.getLeftNode());
            }
            if(null != currNode.getRightNode()) {
                queue.offer(currNode.getRightNode());
            }
        }
    }

    public static <T> void setLevelTree(TreeNode<T> tree) {
        if(null == tree) {
            return;
        }
        Queue<TreeNode<T>> queue = new ArrayDeque<>();
        queue.offer(tree);
        char cc = 'A';
        while(!queue.isEmpty()){
            TreeNode<T> currNode = queue.poll();
            currNode.setValue((T) String.valueOf(cc));
            if(null != currNode.getLeftNode()) {
                queue.offer(currNode.getLeftNode());
            }
            if(null != currNode.getRightNode()) {
                queue.offer(currNode.getRightNode());
            }
            if(cc == 'Z'){
                cc = 'A';
            }else{
                cc++;
            }
        }
    }

    public static void main(String[] args) {
       /* TreeNode<Integer> tree = buildFullThreeTree(3);
        printLevelTree(tree);

        System.out.println();

        setLevelTree(tree);
        printLevelTree(tree);*/


        /*TreeNode<Integer> tree = buildFullTree(4);
        printLevelTree(tree);*/

        TreeNode<Integer> tree1 = buildFullThreeTree(4);
        TreeNode<Integer> tree2 = buildFullThreeTree(4);
        TreeNode<Integer> tree3 = buildFullThreeTree(4);
        tree1.setParentNode(tree2);
        tree2.setParentNode(tree3);
        tree3.setParentNode(tree1);


        printByTree(tree1.getLeftNode(),3);


    }

}
