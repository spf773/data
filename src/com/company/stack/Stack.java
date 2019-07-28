package com.company.stack;

/**
 * 栈
 * auth spf
 * @param <E>
 */
public interface Stack<E> {

    /**
     * 获取栈内数据的长度
     * @return
     */
    int getSize();

    /**
     * 查看栈内是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 向栈尾添加元素
     * @param e
     */
    void push(E e);

    /**
     * 删除最后一个栈元素并返回删除的元素信息
     * @return
     */
    E pop();

    /**
     * 查看最后一个栈元素信息
     * @return
     */
    E peek();
}
