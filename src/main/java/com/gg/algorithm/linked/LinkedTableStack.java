package com.gg.algorithm.linked;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 单向链表-实现一个栈（先进后出）
 */
@Data
@NoArgsConstructor
public class LinkedTableStack {

    private LinkedNode topNode; //栈顶节点

    /**
     * 添加元素-入栈
     * @param value
     */
    public void push(int value){
        LinkedNode newNode = new LinkedNode(value);
        if(null == topNode){
            topNode = newNode;
        } else {
            newNode.setNext(this.topNode);
            this.topNode = newNode;
        }
    }

    /**
     * 弹出元素-出栈
     */
    public int pop(){
        if(null == topNode){
            throw new RuntimeException("stack is null!");
        }
        int value = this.topNode.getValue();
        this.topNode = this.topNode.getNext();
        return value;
    }

    /**
     * 获取站顶值-不弹出
     * @return
     */
    public int peek(){
        if(null == topNode){
            throw new RuntimeException("stack is null!");
        }
        return this.topNode.getValue();
    }


}
