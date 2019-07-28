package com.company.stack;

/**
 * ջ
 * auth spf
 * @param <E>
 */
public interface Stack<E> {

    /**
     * ��ȡջ�����ݵĳ���
     * @return
     */
    int getSize();

    /**
     * �鿴ջ���Ƿ�Ϊ��
     * @return
     */
    boolean isEmpty();

    /**
     * ��ջβ���Ԫ��
     * @param e
     */
    void push(E e);

    /**
     * ɾ�����һ��ջԪ�ز�����ɾ����Ԫ����Ϣ
     * @return
     */
    E pop();

    /**
     * �鿴���һ��ջԪ����Ϣ
     * @return
     */
    E peek();
}
