package com.company.linkedlist;

/**
 * 链表
 * @param <E>
 */
public class LinkedList<E> {

    //链表内部数据结构
    private class Node{
        public E e;
        //存储指向下一个节点的引用
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
     * 返回链表的元素数量
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 检查链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }


    /**
     * 在链表指定位置添加元素
     * @param index 要添加的位置索引，链表种不常使用索引，仅供练习使用
     * @param e 要添加的元素
     */
    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add Failed , Illegal index");
        }
        //dummyHead为虚拟头节点，在链表第一个元素的前一个位置，不计做链表内的元素
        Node prev = dummyHead;
        //从头开始遍历，直到遍历到要添加的位置的前一个元素，将它赋值给prev
        for (int i = 0; i < index; i++) {
            //因为prev的数据结构是储存自己本身的值和存储指向下一个节点的引用的next,所以将prev指向的下一个节点的引用赋值给prev,
            //这样prev的值就是它指向的下一个节点的值，也就是说原本的prev的值就变成了prev.next的值，
            //原本的prev.next指向的引用就变成了prev.next.next的引用,以此类推，也就是说prev向后挪动了一个位置
            //举个例子，prev 本来的下标为0 ，prev.next指向的元素的下表为1 ，prev = prev.next;执行之后，prev下标就变成1 ，
            //prev.next指向的元素的下标就变成了2 ，直到index前一个元素的位置，也就是要添加的索引位置的前一个位置
            //这里有种递归的意思
            prev = prev.next;
        }
//        Node node = new Node(e);
//        node.next = prev.next;
//        prev.next = node;
        //以上三行代码可以用下面一行代替
        prev.next = new Node(e,prev.next);
        size ++;

    }

    /**
     * 在链表的起始位置添加元素
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 向链表末尾添加元素
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 查询索引为index的元素
     * @param index ，链表种不常使用索引，仅供练习使用
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Index illegal");
        }
        //因为dummyHead是虚拟头节点，不存在链表中，只是这个虚拟头节点的next指向的是链表的第一个元素，也就是索引为0的元素
        Node cur = dummyHead.next;
        //链表最后一个元素的next是null
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取链表中第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取链表中最后一个元素
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 替换链表中的某个元素
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Index illegal");
        }
        //因为dummyHead是虚拟头节点，不存在链表中，只是这个虚拟头节点的next指向的是链表的第一个元素，也就是索引为0的元素
        Node cur = dummyHead.next;
        //链表最后一个元素的next是null
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 检查链表中是否存在该元素
     * @param e
     * @return
     */
    public boolean contains(E e){
        //因为dummyHead是虚拟头节点，不存在链表中，只是这个虚拟头节点的next指向的是链表的第一个元素，也就是索引为0的元素
        Node cur = dummyHead.next;
        //链表最后一个元素的next是null
        while(cur.next != null){
            if(cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除索引为index的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("index illegal");
        }
        //删除操作其实就是将要删除的元素的前一个元素的next指向将要删除的元素的后一个元素
        //比如 0 的next 指向 1 ， 1的next指向 2 ， 现在要删除 1 这个元素，其实就是将 0 的next跳过1 ，指向 2这个元素
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            //循环到将要删除的元素的前一个元素
            prev = prev.next;
        }
        //delNode为将要删除的元素
        Node delNode = prev.next;
        //在这里将prev的next 替换成delNode的next
        prev.next = delNode.next;
        //将delNode的next = null,这样就算是从链表中彻底删除了delNode
        delNode.next = null;

        size --;
        return delNode.e;
    }

    /**
     * 删除链表中的第一个元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除链表中的最后一个元素
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
