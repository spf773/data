package com.company.queue;

/**
 * 循环队列
 * auth spf
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    //队首
    private int front;

    //队尾
    private int tail;

    private int size;

    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    /**
     * 查看队列长度
     * @return
     */
    public int getCapacity(){
        return data.length - 1;
    }

    /**
     * 查看队列已存元素长度
     * @return
     */
    @Override
    public int getSize(){
        return size;
    }

    /**
     * 查看队列是否为空
     * @return
     */
    @Override
    public boolean isEmpty(){
        return front == tail;
    }

    /**
     * 向队列中加入一个元素
     * @param e
     */
    @Override
    public void enqueue(E e){

        if((tail + 1) % data.length == front){
            //队列已满，需要扩容
            reSize(getCapacity() * 2);
        }
        data[tail] = e;

        tail = (tail + 1) % data.length;
        size ++;
    }

    /**
     * 给循环队列扩容
     * @param newCapacity
     */
    private void reSize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    /**
     * 删除队列中第一个元素并返回元素信息
     * @return
     */
    @Override
    public E dequeue(){
        if(isEmpty()){
            throw new IllegalArgumentException("队列为空");
        }
        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        //如果size的长度等于capacity的四分之一的时候进行缩容
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0){
            reSize(getCapacity() / 2);
        }
        return e;
    }

    /**
     * 查看队列中第一个元素
     * @return
     */
    @Override
    public E front(){
        return data[front];
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("LoopQueue : size:" + size + " ,capacity:" + getCapacity() +"\n");
        res.append("front [");
        for (int i = front ; i != tail ; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail){
                res.append(",");
            }
        }
        res.append("] tail , " + size);
        return res.toString();
    }
}
