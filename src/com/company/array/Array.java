package com.company.array;

/**
 * �����ࡢ���鹤����
 * auth spf
 */
public class Array<E> {

    private E[] data;

    private int size;

    /**
     * capacity Ϊ����ĳ���
     * @param capacity
     */
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * �޲ι��췽����Ĭ�ϳ���10
     */
    public Array(){
        this(10);
    }

    /**
     * ��ȡ�����е�Ԫ�ظ���
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * ��ȡ�����еĳ���
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * ��ȡ�����Ƿ�Ϊ��
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * ������ָ��λ���������
     * @param index ����
     * @param e ֵ
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
     * ��Ԫ����������һ��Ԫ��
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * ��Ԫ������ڵ�һ��λ��
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * ����������ȡ��Ӧ��ֵ
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
     * ��ȡ�����һ��Ԫ��
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * ��ȡ�������һ��Ԫ��
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * �޸Ĵ�������ֵ
     * @param index ����
     * @param e ֵ
     */
    public void set(int index,E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("index < 0 Or index >= size");
        }
        data[index] = e;
    }

    /**
     * ��ѯ�������Ƿ������ֵ
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
     * ����e�������е�һ�γ��ֵ�����λ�ã�û���򷵻�-1
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
     * ����e�����������һ�γ��ֵ�����λ�ã�û���򷵻�-1
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
     * ����e�������г��ֵ����е�����λ�ã�û���򷵻�null
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
     * ɾ����������ֵ,����ɾ����ֵ
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
     * ɾ�������е�һ��Ԫ�ز�����ɾ����ֵ
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * ɾ�����������һ��Ԫ�ز�����ɾ����ֵ
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * ɾ��ָ��Ԫ��e
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
     * ��̬��������ĳ���,�����ڲ�ʹ��
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
