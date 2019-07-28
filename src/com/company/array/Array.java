package com.company.array;

/**
 * 数组类、数组工具类
 * auth spf
 */
public class Array<E> {

    private E[] data;

    private int size;

    /**
     * capacity 为数组的长度
     * @param capacity
     */
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造方法，默认长度10
     */
    public Array(){
        this(10);
    }

    /**
     * 获取数组中的元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组中的长度
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 获取数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在数组指定位置添加数据
     * @param index 索引
     * @param e 值
     */
    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("add failed,index > size Or index < 0");
        }
        if(size == data.length){
            resize(2 * data.length);
        }

        for(int i = size - 1 ; i >= index ; i--){
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 在元素最后面添加一个元素
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 在元素添加在第一个位置
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 根据索引获取对应的值
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed,index < 0 Or index >= size");
        }
        return data[index];
    }

    /**
     * 获取数组第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取数组最后一个元素
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 修改此索引的值
     * @param index 索引
     * @param e 值
     */
    public void set(int index,E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("index < 0 Or index >= size");
        }
        data[index] = e;
    }

    /**
     * 查询数组中是否有这个值
     * @param e
     * @return
     */
    public boolean contains(E e){
        for (int i = 0; i < size; i++){
            if(data[i].toString().equals(e.toString())){
                return true;
            }
        }
        return false;
    }

    /**
     * 查找e在数组中第一次出现的索引位置，没有则返回-1
     * @param e
     * @return
     */
    public int findFirst(E e){
        for (int i = 0; i < size; i++){
            if(data[i].toString().equals(e.toString())){
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找e在数组中最后一次出现的索引位置，没有则返回-1
     * @param e
     * @return
     */
    public int findLast(E e){
        for (int i = size -1;i >= 0;i--){
            if(data[i].toString().equals(e.toString())){
                return i;
            }
        }
        return -1;
    }

    /**
     * 返回e在数组中出现的所有的索引位置，没有则返回null
     * @param e
     * @return
     */
    public Array<Integer> findAll(E e){
        Array<Integer> arr = new Array();
        for (int i = 0;i < size;i++){
            if(data[i].toString().equals(e.toString())){
                arr.addLast(i);
            }
        }
        if(arr.size == 0){
            return null;
        }
        return arr;
    }

    /**
     * 删除此索引的值,返回删除的值
     * @param index
     */
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("remove failed,index < 0 Or index >= size");
        }

        E ret = data[index];
        for (int i = index + 1;i < size; i++){
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if(size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * 删除数组中第一个元素并返回删除的值
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除数组中最后一个元素并返回删除的值
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 删除指定元素e
     * @param e
     */
    public void removeElement(E e){
        Array<Integer> array = findAll(e);
        for (int i = 0;i < array.size;i++){
            int index = findFirst(e);
            remove(index);
        }
    }

//    public boolean equals(Object e){
//        if (this == e) {
//            return true;
//        }
//        if(e instanceof E){
//
//
//        }
//        return false;
//    }

    /**
     * 动态更改数组的长度,仅限内部使用
     * @param newCapacity
     */
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0;i < size;i++){
            newData[i] = data[i];
        }
        data = newData;
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Array size="+size+",capacity="+data.length+"\n");
        res.append("[");
        for (int i = 0; i < size; i ++ ){
            res.append(data[i]);
            if(i != size - 1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

}
