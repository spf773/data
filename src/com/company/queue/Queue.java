package com.company.queue;

/**
 * 队列
 * auth spf
 * @param <E>
 */
public interface Queue<E> {

    /**
     * 获取队列元素长度
     * @return
     */
    int getSize();

    /**
     * 判断队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 向队列末尾添加元素
     * @param e
     */
    void enqueue(E e);

    /**
     * 删除队列中第一个元素
     * @return
     */
    E dequeue();

    /**
     * 查看队列中第一个元素
     * @return
     */
    E front();

}
