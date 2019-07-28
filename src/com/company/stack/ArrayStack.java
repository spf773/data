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
     * 获取栈内数据的长度
     * @return
     */
    @Override
    public int getSize(){
        return array.getSize();
    }

    /**
     * 获取栈的长度
     * @return
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    /**
     * 判断栈内是否为空
     * @return
     */
    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    /**
     * 向栈内添加元素
     * @param e
     */
    @Override
    public void push(E e){
        array.addLast(e);
    }

    /**
     * 删除最后一个元素
     * @return
     */
    public E pop(){
        return array.removeLast();
    }

    /**
     * 查看最后一个元素
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
