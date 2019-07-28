package com.company.queue;

/**
 * ʹ����������ݽṹʵ�ֶ���
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

    //��������ͷ�ڵ�
    private Node head;

    //��������β�ڵ�
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
     * ����������Ԫ��
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
     * ɾ������Ԫ�أ����ӣ�
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
            //���ͷ�ڵ�Ϊ�գ���ô��˵�������ǿյģ�β�ڵ�ҲҪΪ��
            tail = null;
        }
        size --;
        return retNode.e;
    }

    /**
     * ��ȡ�����е�һ��Ԫ��
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
