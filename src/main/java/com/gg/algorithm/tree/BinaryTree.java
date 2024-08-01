package com.gg.algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树
 */
public class BinaryTree {

    /**
     * 二叉树最小深度-深度（高度）优先 dfs
     * 递归，找到深度最小的节点返回
     * @param treeNode
     * @return
     */
    public static int minDfsDepth(TreeNode<Object> treeNode) {
        if (null == treeNode) {
            return 0;
        }
        if (null == treeNode.getLeft() && null == treeNode.getRight()) {
            return 1;
        }

        int leftMin = Integer.MAX_VALUE;
        int rightMin = Integer.MAX_VALUE;
        if(null != treeNode.getLeft()){
            // 递归返回左节点深度
            leftMin = minDfsDepth(treeNode.getLeft());
        }
        if(null != treeNode.getRight()){
            // 递归返回右节点深度
            rightMin = minDfsDepth(treeNode.getRight());
        }
        // 比较左节点跟右节点，取深度小的+1返回
        int min = Math.min(leftMin,rightMin);
        //int max = Math.max(leftMin,rightMin);
        System.out.println("min:"+min);
        return min + 1;
    }

    /**
     * 二叉树最小深度-广度（宽度）优先 bfs
     * 采用队列（queue），先进先出，直到找到第一个叶子节点返回深度
     * 否则一直循环找左节点、右节点，deep+1，并加入队列
     * @param treeNode
     * @return
     */
    public static int minBfsDepth(TreeNode<Object> treeNode) {
        if (null == treeNode) {
            return 0;
        }
        treeNode.deep = 1;
        Queue<TreeNode<Object>> queue = new LinkedList<>();
        queue.offer(treeNode);
        while(!queue.isEmpty()){
            TreeNode<Object> currNode = queue.poll();
            System.out.println(currNode.value);
            if(null == currNode.getLeft() && null == currNode.getRight()){
                return currNode.deep; // 已经找到最浅的节点，返回当前节点深度即可
            }
            if(currNode.getLeft() != null){
                currNode.getLeft().deep = currNode.deep+1;
                queue.offer(currNode.getLeft());
            }
            if(currNode.getRight() != null){
                currNode.getRight().deep = currNode.deep+1;
                queue.offer(currNode.getRight());
            }
        }
        return 0;
    }

    /**
     * 构建满二叉-迭代
     * @param deep
     * @return
     */
    public static TreeNode<Object> buildFullTree(int deep){
        if(deep < 1){
            return null;
        }
        TreeNode<Object> tree = new TreeNode<>(1);
        if(deep == 1){
            return tree;
        }
        Queue<TreeNode<Object>> queue = new LinkedList<>();
        queue.offer(tree);
        for (int i = 1; i < Math.pow(2,deep-1); i++) {

            TreeNode<Object> parentNode = queue.poll();

            TreeNode<Object> leftNode = new TreeNode<>(2*i);
            parentNode.setLeft(leftNode);
            queue.offer(leftNode);

            TreeNode<Object> rightNode = new TreeNode<>(2*i+1);
            parentNode.setRight(rightNode);
            queue.offer(rightNode);
        }
        return tree;
    }

    /**
     * 构建满二叉-递归
     * 特点：
     * 1、每层都是满的
     * 2、叶子节点全部在最底层
     * 3、节点顺序，从上到下，从左到右。
     * 满二叉树一定是一个完全二叉树，反之不一定
     * @param depth 树的深度
     * @param value 初始值
     * @return
     */
    public static TreeNode<Object> buildFullTree(int depth,int value) {
        if(depth < 1){
            return null;
        }
        TreeNode<Object> root = new TreeNode<>(value);

        TreeNode<Object> leftNode = buildFullTree(depth - 1, 2 * value);
        root.setLeft(leftNode);
        TreeNode<Object> rightNode = buildFullTree(depth - 1, 2 * value + 1);
        root.setRight(rightNode);
        return root;
    }

    /**
     * 二叉树遍历-递归
     * 前序（根左右）、中序（左根右）、后序（左右根）
     * @param root
     */
    public static void recursionOrder(TreeNode<Object> root){
        if(null == root){
            return;
        }
        // 前序遍历1245673
        // System.out.println(root.value);
        recursionOrder(root.getLeft());
        // 中序遍历4265713
        // System.out.println(root.value);
        recursionOrder(root.getRight());
        // 后序遍历4675231
        System.out.println(root.value);

    }

    /**
     * 二叉树遍历-递归
     * 层序遍历
     * @param root
     */
    public static void levelOrder(TreeNode<Integer> root, int index, List<Integer> list){
        if(null == root || index < 1){
            return;
        }
        int lenght = list.size();
        if(lenght <= index){
            for(int i=0; i<=index-lenght; i++){
                list.add(lenght+i,null);
            }
        }
        list.set(index,root.value);
        levelOrder(root.getLeft(),2*index,list);
        levelOrder(root.getRight(),2*index+1,list);
    }

    /**
     * 二叉树遍历-迭代
     * 层序遍历
     * @param tree
     */
    public static void levelOrder(TreeNode<Object> tree){
        if(null == tree){
            return;
        }
        Queue<TreeNode<Object>> queue = new LinkedList<>();
        queue.offer(tree);
        while (!queue.isEmpty()){
            TreeNode<Object> currNode = queue.poll();
            System.out.print(currNode.value + " ");
            if(null != currNode.getLeft()){
                queue.offer(currNode.getLeft());
            }
            if(null != currNode.getRight()){
                queue.offer(currNode.getRight());
            }
        }
    }

    public static void updateTree(TreeNode<Object> tree){
        if(null == tree){
            return;
        }
        char cc = 'A';
        Queue<TreeNode<Object>> queue = new LinkedList<>();
        queue.offer(tree);
        while (!queue.isEmpty()){
            TreeNode<Object> currNode = queue.poll();
            currNode.setValue(cc);
            if(null != currNode.getLeft()){
                queue.offer(currNode.getLeft());
            }
            if(null != currNode.getRight()){
                queue.offer(currNode.getRight());
            }
            if(cc == 'Z'){
                cc = 'A';
            } else {
                cc++;
            }
        }
    }


    public static void main(String[] args) {
        TreeNode<Object> node7 = new TreeNode<>(7, null, null);
        TreeNode<Object> node6 = new TreeNode<>(6, null, null);
        TreeNode<Object> node5 = new TreeNode<>(5, node6, node7);
        TreeNode<Object> node4 = new TreeNode<>(4, null, null);
        TreeNode<Object> node3 = new TreeNode<>(3, null, null);
        TreeNode<Object> node2 = new TreeNode<>(2, node4, node5);
        TreeNode<Object> node1 = new TreeNode<>(1, node2, node3);

        levelOrder(node1);

       /* List<Integer> list = new ArrayList<>();
        levelOrder(node1,1,list);
        list.removeIf(item -> item == null);
        System.out.println(Arrays.toString(list.toArray()));*/

        //TreeNode fullTrue = buildFullTree(3, 1);
        System.out.println(minDfsDepth(node1));
        //System.out.println(minBfsDepth(node1));


    }



}
