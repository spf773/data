package com.company.stack;

import com.company.linkedlist.LinkedList;

/**
 * 使用链表实现一个栈的数据结构
 * 因为栈是后进先出的特性，所以操作链表也都是操作链表的第一个元素
 * @param <E>
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack(){
        list = new LinkedList<>();
    }

    /**
     * 返回栈中有多少个元素
     * @return
     */
    @Override
    public int getSize(){
        return list.getSize();
    }

    /**
     * 返回栈是否为空
     * @return
     */
    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

    /**
     * 向栈尾添加元素
     */
    @Override
    public void push(E e){
        list.addFirst(e);
    }

    /**
     * 删除最后一个栈元素并返回该元素的值
     * @return
     */
    @Override
    public E pop(){
        return list.removeFirst();
    }

    /**
     * 查看栈的最后一个元素
     * @return
     */
    @Override
    public E peek(){
        return list.getFirst();
    }
}
