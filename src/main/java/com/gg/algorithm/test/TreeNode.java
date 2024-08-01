package com.gg.algorithm.test;

import lombok.Data;

/**
 * 二叉树-带父节点
 * @param <T>
 */
@Data
public class TreeNode<T> {

    private T value;
    private TreeNode<T> parentNode;
    private TreeNode<T> leftNode;
    private TreeNode<T> rightNode;

    public TreeNode(T value) {
        this.value = value;
    }

    public TreeNode(T value, TreeNode<T> parentNode) {
        this.value = value;
        this.parentNode = parentNode;
    }
}
