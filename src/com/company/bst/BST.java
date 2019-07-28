package com.company.bst;

/**
 * �����������������������ݽṹ
 * �����������ݱ�����пɱȽ��ԣ����Է��ͼ̳���Comparable
 */
public class BST<E extends Comparable<E>> {

    /**
     * �������ڲ��洢���ݵ����ݽṹ
     */
    private class Node {
        //�ڵ��ڴ洢������
        public E e;
        //�ýڵ�ָ������ӽڵ�
        public Node left;
        //�ýڵ�ָ����Һ��ӽڵ�
        public Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    //�������ĸ��ڵ�
    private Node root;

    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    /**
     * ���ض��������ж��ٸ��ڵ�
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * �������Ƿ�Ϊ��
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * �������
     * @param e
     */
    public void add(E e){
        if(root == null){
            root = new Node(e);
        }else{
            add(root,e);
        }
    }

    /**
     * �������
     * compareTo�����ǱȽ�����ֵ�Ĵ�С�����node.e С�� e ����ֵΪ-1������e ����ֵΪ0������e����ֵΪ1
     * �ڶ������ṹ�У����ӽڵ���ԶС�ڸ��ڵ㣨����Ҷ�ӽڵ㣬�����ڵ㶼�����Ǹ��ڵ㣩�����ӽڵ���Զ���ڸ��ڵ�
     * ���ڵ����Ԫ�ز����ظ�
     * @param node ���ڵ�
     * @param e Ҫ��ӵ�ֵ��Ԫ�أ�
     */
    public void add(Node node,E e){
        if(node.e.equals(e)){
            return;
        }else if(node.e.compareTo(e) < 0 && node.left == null){

            node.left = new Node(e);
            size ++;
            return;
        }else if(node.e.compareTo(e) > 0 && node.right == null) {
            node.right = new Node(e);
            size ++;
            return;
        }
        //�˴��ݹ���ñ������ṹ�����������
        if(node.e.compareTo(e) < 0){
            add(node.left,e);
        }else{
            add(node.right,e);
        }
    }

}
