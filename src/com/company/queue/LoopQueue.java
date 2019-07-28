package com.company.queue;

/**
 * ѭ������
 * auth spf
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    //����
    private int front;

    //��β
    private int tail;

    private int size;

    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    /**
     * �鿴���г���
     * @return
     */
    public int getCapacity(){
        return data.length - 1;
    }

    /**
     * �鿴�����Ѵ�Ԫ�س���
     * @return
     */
    @Override
    public int getSize(){
        return size;
    }

    /**
     * �鿴�����Ƿ�Ϊ��
     * @return
     */
    @Override
    public boolean isEmpty(){
        return front == tail;
    }

    /**
     * ������м���һ��Ԫ��
     * @param e
     */
    @Override
    public void enqueue(E e){

        if((tail + 1) % data.length == front){
            //������������Ҫ����
            reSize(getCapacity() * 2);
        }
        data[tail] = e;

        tail = (tail + 1) % data.length;
        size ++;
    }

    /**
     * ��ѭ����������
     * @param newCapacity
     */
    private void reSize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    /**
     * ɾ�������е�һ��Ԫ�ز�����Ԫ����Ϣ
     * @return
     */
    @Override
    public E dequeue(){
        if(isEmpty()){
            throw new IllegalArgumentException("����Ϊ��");
        }
        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        //���size�ĳ��ȵ���capacity���ķ�֮һ��ʱ���������
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0){
            reSize(getCapacity() / 2);
        }
        return e;
    }

    /**
     * �鿴�����е�һ��Ԫ��
     * @return
     */
    @Override
    public E front(){
        return data[front];
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("LoopQueue : size:" + size + " ,capacity:" + getCapacity() +"\n");
        res.append("front [");
        for (int i = front ; i != tail ; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail){
                res.append(",");
            }
        }
        res.append("] tail , " + size);
        return res.toString();
    }
}
