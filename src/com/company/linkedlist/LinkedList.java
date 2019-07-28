package com.company.linkedlist;

/**
 * ����
 * @param <E>
 */
public class LinkedList<E> {

    //�����ڲ����ݽṹ
    private class Node{
        public E e;
        //�洢ָ����һ���ڵ������
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

    private Node dummyHead;

    private int size;

    public LinkedList(){
        dummyHead = new Node();
        size = 0;
    }

    /**
     * ���������Ԫ������
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * ��������Ƿ�Ϊ��
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }


    /**
     * ������ָ��λ�����Ԫ��
     * @param index Ҫ��ӵ�λ�������������ֲ���ʹ��������������ϰʹ��
     * @param e Ҫ��ӵ�Ԫ��
     */
    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add Failed , Illegal index");
        }
        //dummyHeadΪ����ͷ�ڵ㣬�������һ��Ԫ�ص�ǰһ��λ�ã������������ڵ�Ԫ��
        Node prev = dummyHead;
        //��ͷ��ʼ������ֱ��������Ҫ��ӵ�λ�õ�ǰһ��Ԫ�أ�������ֵ��prev
        for (int i = 0; i < index; i++) {
            //��Ϊprev�����ݽṹ�Ǵ����Լ������ֵ�ʹ洢ָ����һ���ڵ�����õ�next,���Խ�prevָ�����һ���ڵ�����ø�ֵ��prev,
            //����prev��ֵ������ָ�����һ���ڵ��ֵ��Ҳ����˵ԭ����prev��ֵ�ͱ����prev.next��ֵ��
            //ԭ����prev.nextָ������þͱ����prev.next.next������,�Դ����ƣ�Ҳ����˵prev���Ų����һ��λ��
            //�ٸ����ӣ�prev �������±�Ϊ0 ��prev.nextָ���Ԫ�ص��±�Ϊ1 ��prev = prev.next;ִ��֮��prev�±�ͱ��1 ��
            //prev.nextָ���Ԫ�ص��±�ͱ����2 ��ֱ��indexǰһ��Ԫ�ص�λ�ã�Ҳ����Ҫ��ӵ�����λ�õ�ǰһ��λ��
            //�������ֵݹ����˼
            prev = prev.next;
        }
//        Node node = new Node(e);
//        node.next = prev.next;
//        prev.next = node;
        //�������д������������һ�д���
        prev.next = new Node(e,prev.next);
        size ++;

    }

    /**
     * ���������ʼλ�����Ԫ��
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * ������ĩβ���Ԫ��
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * ��ѯ����Ϊindex��Ԫ��
     * @param index �������ֲ���ʹ��������������ϰʹ��
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Index illegal");
        }
        //��ΪdummyHead������ͷ�ڵ㣬�����������У�ֻ���������ͷ�ڵ��nextָ���������ĵ�һ��Ԫ�أ�Ҳ��������Ϊ0��Ԫ��
        Node cur = dummyHead.next;
        //�������һ��Ԫ�ص�next��null
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * ��ȡ�����е�һ��Ԫ��
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * ��ȡ���������һ��Ԫ��
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * �滻�����е�ĳ��Ԫ��
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Index illegal");
        }
        //��ΪdummyHead������ͷ�ڵ㣬�����������У�ֻ���������ͷ�ڵ��nextָ���������ĵ�һ��Ԫ�أ�Ҳ��������Ϊ0��Ԫ��
        Node cur = dummyHead.next;
        //�������һ��Ԫ�ص�next��null
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * ����������Ƿ���ڸ�Ԫ��
     * @param e
     * @return
     */
    public boolean contains(E e){
        //��ΪdummyHead������ͷ�ڵ㣬�����������У�ֻ���������ͷ�ڵ��nextָ���������ĵ�һ��Ԫ�أ�Ҳ��������Ϊ0��Ԫ��
        Node cur = dummyHead.next;
        //�������һ��Ԫ�ص�next��null
        while(cur.next != null){
            if(cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * ɾ������Ϊindex��Ԫ��
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("index illegal");
        }
        //ɾ��������ʵ���ǽ�Ҫɾ����Ԫ�ص�ǰһ��Ԫ�ص�nextָ��Ҫɾ����Ԫ�صĺ�һ��Ԫ��
        //���� 0 ��next ָ�� 1 �� 1��nextָ�� 2 �� ����Ҫɾ�� 1 ���Ԫ�أ���ʵ���ǽ� 0 ��next����1 ��ָ�� 2���Ԫ��
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            //ѭ������Ҫɾ����Ԫ�ص�ǰһ��Ԫ��
            prev = prev.next;
        }
        //delNodeΪ��Ҫɾ����Ԫ��
        Node delNode = prev.next;
        //�����ｫprev��next �滻��delNode��next
        prev.next = delNode.next;
        //��delNode��next = null,���������Ǵ������г���ɾ����delNode
        delNode.next = null;

        size --;
        return delNode.e;
    }

    /**
     * ɾ�������еĵ�һ��Ԫ��
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * ɾ�������е����һ��Ԫ��
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Node : ");
        Node cur = dummyHead.next;
        while(cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }


}
