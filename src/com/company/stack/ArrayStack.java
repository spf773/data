package com.company.stack;

import com.company.array.Array;

public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack(int capacity){
        array = new Array<>();
    }

    public ArrayStack(){
        array = new Array<>();
    }

    /**
     * ��ȡջ�����ݵĳ���
     * @return
     */
    @Override
    public int getSize(){
        return array.getSize();
    }

    /**
     * ��ȡջ�ĳ���
     * @return
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    /**
     * �ж�ջ���Ƿ�Ϊ��
     * @return
     */
    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    /**
     * ��ջ�����Ԫ��
     * @param e
     */
    @Override
    public void push(E e){
        array.addLast(e);
    }

    /**
     * ɾ�����һ��Ԫ��
     * @return
     */
    public E pop(){
        return array.removeLast();
    }

    /**
     * �鿴���һ��Ԫ��
     * @return
     */
    public E peek(){
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("ArrayStock : [");
        for (int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1){
                res.append(",");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
