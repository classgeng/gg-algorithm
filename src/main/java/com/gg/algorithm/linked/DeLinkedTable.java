package com.gg.algorithm.linked;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeLinkedTable {

    private DeLinkedNode topNode;

    private DeLinkedNode tailNode;

    private int size;

    public void push(int value) {
        DeLinkedNode currNode = new DeLinkedNode(value);
        if(null == topNode) {
            topNode = currNode;
            tailNode = topNode;
        } else {
            topNode.setPrev(currNode);
            currNode.setNext(topNode);
            topNode = currNode;
        }
        this.size++;
    }

    public int pop() {
        if(null == topNode) {
            System.out.println("stack is null!");
            return -1;
        } else {
            int value = topNode.getValue();
            topNode = topNode.getNext();
            if(null != topNode) {
                topNode.setPrev(null);
            }
            this.size--;
            return value;
        }
    }

    public int peek() {
        if(null == topNode) {
            System.out.println("stack is null!");
            return -1;
        } else {
            return topNode.getValue();
        }
    }

    public int pull() {
        if(null == tailNode) {
            System.out.println("stack is null!");
            return -1;
        } else {
            int value = tailNode.getValue();
            tailNode = tailNode.getPrev();
            if(null != topNode) {
                topNode.setNext(null);
            }
            this.size--;
            return value;
        }
    }

}
