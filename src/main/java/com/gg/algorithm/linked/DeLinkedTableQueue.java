package com.gg.algorithm.linked;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 双向链表-实现一个双端队列（先进先出）
 */
@Data
@NoArgsConstructor
public class DeLinkedTableQueue {

    private DeLinkedNode headNode; //头节点

    private DeLinkedNode tailNode; //尾节点

    private int size; //大小

    /**
     * 添加元素到队列尾部-入队
     * @param value
     */
    public void offer(int value){
        DeLinkedNode newNode = new DeLinkedNode(value);
        if(null == this.tailNode){
            this.tailNode = newNode;
            this.headNode = this.tailNode;
        } else {
            this.tailNode.setNext(newNode);
            newNode.setPrev(this.tailNode);
            this.tailNode = newNode;
        }
        this.size++;
    }

    /**
     * 从头部弹出元素-出队
     */
    public int pull(){
        if(null == this.headNode){
            throw new RuntimeException("queue is null!");
        }
        int value = this.headNode.getValue();
        this.headNode = this.headNode.getNext();
        if(null != this.headNode){
            this.headNode.setPrev(null);
        } else {
            this.tailNode = null;
        }
        this.size--;
        return value;
    }

    /**
     * 添加元素到头部-入队
     * @param value
     */
    public void offerHead(int value){
        DeLinkedNode newNode = new DeLinkedNode(value);
        if(null == this.headNode){
            this.headNode = newNode;
            this.tailNode = this.headNode;
        } else {
            this.headNode.setPrev(newNode);
            newNode.setNext(headNode);
            this.headNode = newNode;
        }
        this.size++;
    }

    /**
     * 从尾部弹出元素-出队
     */
    public int pullLast(){
        if(null == this.tailNode){
            throw new RuntimeException("queue is null!");
        }
        int value = this.tailNode.getValue();
        this.tailNode = this.tailNode.getPrev();
        if(null != this.tailNode){
            this.tailNode.setNext(null);
        } else {
            this.headNode = null;
        }
        this.size--;
        return value;
    }

    /**
     * 获取头部值-不弹出
     * @return
     */
    public int peek(){
        if(null == this.headNode){
            throw new RuntimeException("stack is null!");
        }
        return this.headNode.getValue();
    }

    /**
     * 获取尾部值-不弹出
     * @return
     */
    public int peekLast(){
        if(null == this.tailNode){
            throw new RuntimeException("stack is null!");
        }
        return this.tailNode.getValue();
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

}
