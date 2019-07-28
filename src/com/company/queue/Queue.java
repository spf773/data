package com.company.queue;

/**
 * ����
 * auth spf
 * @param <E>
 */
public interface Queue<E> {

    /**
     * ��ȡ����Ԫ�س���
     * @return
     */
    int getSize();

    /**
     * �ж϶����Ƿ�Ϊ��
     * @return
     */
    boolean isEmpty();

    /**
     * �����ĩβ���Ԫ��
     * @param e
     */
    void enqueue(E e);

    /**
     * ɾ�������е�һ��Ԫ��
     * @return
     */
    E dequeue();

    /**
     * �鿴�����е�һ��Ԫ��
     * @return
     */
    E front();

}
