package com.company.queue;

import com.company.array.Array;

public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity){
        array = new Array<>();
    }

    public ArrayQueue(){
        array = new Array<>();
    }

    /**
     * 获取队列元素长度
     * @return
     */
    @Override
    public int getSize(){
        return array.getSize();
    }

    /**
     * 判断队列内是否为空
     * @return
     */
    public boolean isEmpty(){
        return array.isEmpty();
    }

    /**
     * 在队列末尾添加元素
     * @param e
     */
    @Override
    public void enqueue(E e){
        array.addLast(e);
    }

    /**
     * 删除队列第一个元素并返回元素信息
     * @return
     */
    @Override
    public E dequeue(){
        return array.removeFirst();
    }

    /**
     * 获取队列内第一个元素信息
     * @return
     */
    @Override
    public E front(){
        return array.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("ArrayQueue : front [");
        for (int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

}
