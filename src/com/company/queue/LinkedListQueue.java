package com.company.queue;

/**
 * 使用链表的数据结构实现队列
 * @param <E>
 */
public class LinkedListQueue<E> implements Queue<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }
        @Override
        public String toString(){
            return e.toString();
        }
    }

    //存放链表的头节点
    private Node head;

    //存放链表的尾节点
    private Node tail;

    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向队列中添加元素
     * @param e
     */
    public void enqueue(E e){
        if(tail == null){
            tail = new Node(e);
            head = tail;
        }else{
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    /**
     * 删除队首元素（出队）
     * @return
     */
    @Override
    public E dequeue(){
        if(isEmpty()){
            throw new IllegalArgumentException("dequeue failed , queue is null");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if(head == null){
            //如果头节点为空，那么就说明队列是空的，尾节点也要为空
            tail = null;
        }
        size --;
        return retNode.e;
    }

    /**
     * 获取队列中第一个元素
     * @return
     */
    @Override
    public E front(){
        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Node : front ");
        Node cur = head;
        while(cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }
}
