package com.company.stack;

import com.company.linkedlist.LinkedList;

/**
 * ʹ������ʵ��һ��ջ�����ݽṹ
 * ��Ϊջ�Ǻ���ȳ������ԣ����Բ�������Ҳ���ǲ�������ĵ�һ��Ԫ��
 * @param <E>
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack(){
        list = new LinkedList<>();
    }

    /**
     * ����ջ���ж��ٸ�Ԫ��
     * @return
     */
    @Override
    public int getSize(){
        return list.getSize();
    }

    /**
     * ����ջ�Ƿ�Ϊ��
     * @return
     */
    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

    /**
     * ��ջβ���Ԫ��
     */
    @Override
    public void push(E e){
        list.addFirst(e);
    }

    /**
     * ɾ�����һ��ջԪ�ز����ظ�Ԫ�ص�ֵ
     * @return
     */
    @Override
    public E pop(){
        return list.removeFirst();
    }

    /**
     * �鿴ջ�����һ��Ԫ��
     * @return
     */
    @Override
    public E peek(){
        return list.getFirst();
    }
}
