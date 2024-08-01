package com.gg.algorithm.linked;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 双向链表-节点信息
 */
@Data
@NoArgsConstructor
public class DeLinkedNode {

    private int value;

    private DeLinkedNode prev;

    private DeLinkedNode next;

    public DeLinkedNode(int value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    @Override
    public String toString() {
        return "DeLinkedNode{" +
                "value=" + value +
                '}';
    }
}
