package com.company.bst;

/**
 * 二叉树（二分搜索树）数据结构
 * 二叉树的数据必须具有可比较性，所以泛型继承了Comparable
 */
public class BST<E extends Comparable<E>> {

    /**
     * 二叉树内部存储数据的数据结构
     */
    private class Node {
        //节点内存储的数据
        public E e;
        //该节点指向的左孩子节点
        public Node left;
        //该节点指向的右孩子节点
        public Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    //二叉树的根节点
    private Node root;

    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    /**
     * 返回二叉树中有多少个节点
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 二叉树是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加数据
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
     * 添加数据
     * compareTo方法是比较两个值的大小，如果node.e 小于 e 返回值为-1，等于e 返回值为0，大于e返回值为1
     * 在二叉树结构中，左子节点永远小于根节点（除了叶子节点，其他节点都可以是根节点），右子节点永远大于根节点
     * 树节点里的元素不能重复
     * @param node 根节点
     * @param e 要添加的值（元素）
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
        //此处递归调用遍历树结构进行添加数据
        if(node.e.compareTo(e) < 0){
            add(node.left,e);
        }else{
            add(node.right,e);
        }
    }

}
