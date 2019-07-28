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
     * ��ȡ����Ԫ�س���
     * @return
     */
    @Override
    public int getSize(){
        return array.getSize();
    }

    /**
     * �ж϶������Ƿ�Ϊ��
     * @return
     */
    public boolean isEmpty(){
        return array.isEmpty();
    }

    /**
     * �ڶ���ĩβ���Ԫ��
     * @param e
     */
    @Override
    public void enqueue(E e){
        array.addLast(e);
    }

    /**
     * ɾ�����е�һ��Ԫ�ز�����Ԫ����Ϣ
     * @return
     */
    @Override
    public E dequeue(){
        return array.removeFirst();
    }

    /**
     * ��ȡ�����ڵ�һ��Ԫ����Ϣ
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
