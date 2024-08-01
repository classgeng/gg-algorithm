package com.gg.algorithm.tree;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TreeNode<T> {

    T value;
    TreeNode<T> parent;
    TreeNode<T> left;
    TreeNode<T> right;
    int deep;

    public TreeNode(T value) {
        this.value = value;
    }

    public TreeNode(T value, TreeNode<T> leftNode, TreeNode<T> rightNode){
        this.value = value;
        this.left = leftNode;
        this.right = rightNode;
    }
}
