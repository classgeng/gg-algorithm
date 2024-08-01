package com.gg.algorithm.linked;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 单向链表-实现一个栈（先进先出）
 */
@Data
@NoArgsConstructor
public class LinkedTableQueue {

    private LinkedNode headNode; //头节点

    private LinkedNode tailNode; //尾节点

    /**
     * 添加元素-入队
     * @param value
     */
    public void offer(int value){
        LinkedNode newNode = new LinkedNode(value);
        if(null == this.tailNode){
            this.tailNode = newNode;
            this.headNode = this.tailNode;
        } else {
            this.tailNode.setNext(newNode);
            this.tailNode = newNode;
        }
    }

    /**
     * 弹出元素-出队
     */
    public int pull(){
        if(null == headNode){
            throw new RuntimeException("stack is null!");
        }
        int value = this.headNode.getValue();
        this.headNode = this.headNode.getNext();
        return value;
    }

    /**
     * 获取站顶值-不弹出
     * @return
     */
    public int peek(){
        if(null == headNode){
            throw new RuntimeException("stack is null!");
        }
        return this.headNode.getValue();
    }


}
