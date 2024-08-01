package com.gg.algorithm.linked;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 双向链表-实现一个栈（先进后出）
 */
@Data
@NoArgsConstructor
public class DeLinkedTableStack {

    private DeLinkedNode topNode; //栈顶节点

    private int size; //栈大小

    /**
     * 添加元素-入栈
     * @param value
     */
    public void push(int value){
        DeLinkedNode newNode = new DeLinkedNode(value);
        if(this.size == 0){
            topNode = newNode;
        } else {
            newNode.setNext(topNode);
            this.topNode.setPrev(newNode);
            this.topNode = newNode;
        }
        this.size++;
    }

    /**
     * 弹出元素-出栈
     */
    public int pop(){
        if(this.size == 0){
            throw new RuntimeException("stack is null!");
        }
        int value = this.topNode.getValue();
        this.topNode = this.topNode.getNext();
        if(null != this.topNode){
           this.topNode.setPrev(null);
        }
        this.size--;
        return value;
    }

    /**
     * 获取站顶值-不弹出
     * @return
     */
    public int peek(){
        if(this.size == 0){
            throw new RuntimeException("stack is null!");
        }
        return this.topNode.getValue();
    }

    public int pull(){
        if(this.size == 0){
            throw new RuntimeException("stack is null!");
        }
        DeLinkedNode tailNode = this.recursion(this.topNode);
        if(null != tailNode.getPrev()){
            tailNode.getPrev().setNext(null);
        }
        this.size--;
        return tailNode.getValue();

    }

    public DeLinkedNode recursion(DeLinkedNode currNode){
        if(null == currNode.getNext()){
            return currNode;
        }
        return recursion(currNode.getNext());
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    @Override
    public String toString() {
        return "DeLinkedTableStack{" +
                ", size=" + size +
                '}';
    }
}
