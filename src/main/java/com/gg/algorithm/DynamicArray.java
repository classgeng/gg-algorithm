package com.gg.algorithm;

public class DynamicArray {

    private int size = 0;

    private int capacity = 8;

    private int[] array = {};


    public int get(int index){
        return array[index];
    }


    //向指定位置添加元素
    public void add(int index,int element) {

        if (index >= 0 && index <= size - 1) {
            //插入的位置是在数组内
            //将第一个参数的array数组从index索引开始移动到（复制）到第三个参数的array数组从索引index+1开始，移动的数量是size-index
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        //不符合条件的也就是>=size的，下面逻辑也可以走，索引<0暂时不考虑
        array[index] = element;
        size++;

    }

    //删除指定索引的值，返回被删除的值
    public int remove(int index) {
        int removed = array[index];//被删除的值
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        //如果删除的索引是最后一个，直接逻辑大小减一就行
        size--;
        return removed;
    }

}
