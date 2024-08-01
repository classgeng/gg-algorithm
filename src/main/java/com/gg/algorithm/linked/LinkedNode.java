package com.gg.algorithm.linked;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 单向链表-节点信息
 */
@Data
@NoArgsConstructor
public class LinkedNode {

    private int value;

    private LinkedNode next;

    public LinkedNode(int value) {
        this.value = value;
    }

    public LinkedNode(int value, LinkedNode next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "LinkedNode{" +
                "value=" + value +
                '}';
    }
}
