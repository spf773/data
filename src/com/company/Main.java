package com.company;

import com.company.Exception.MessageException;
import com.company.array.Array;
import com.company.linkedlist.LinkedList;
import com.company.queue.ArrayQueue;
import com.company.queue.LoopQueue;
import com.company.queue.Queue;
import com.company.stack.ArrayStack;
import com.company.stack.Stack;

import java.util.HashMap;


public class Main {


    public class nei{//�ڲ���
        public void test(B a){
            System.out.println("000");
            new Main().isValid("[()]");
            class B{//�ֲ��ڲ���

            }

        }
        public void main(String[] args) {
            //�����ڲ��࣬ʹ�������ڲ���ʱ�����Ǳ����Ǽ̳�һ�������ʵ��һ���ӿڣ��������߲��ɼ�ã�ͬʱҲֻ�ܼ̳�һ�������ʵ��һ���ӿڣ�ͬʱҲ���ھֲ��ڲ���
            test(new B() {
                @Override
                public void A(Stack<Integer> stack) {

                }
            });
        }

    }

    public static class jing{//��̬�ڲ���

    }


    private static double testQueue(Queue<Integer> q,int opCount){

        long startTime = System.nanoTime();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(i);
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
            System.out.println(list);
        }
        list.add(2,666);
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        list.removeFirst();
        System.out.println(list);

        list.removeLast();
        System.out.println(list);
    }


    //ð��
    public void sort(){
        int[] arr = {1,56,96,9,5,85,87};
        for (int i = 0 ;i < arr.length -1 ;i++){
            for (int j = 0 ;j < arr.length - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
        }
        for (int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    //��ӡ�ȱ�������
    public void delta(int num){
        for (int i = 0; i < num;i ++){
            for (int j = num; j > i ;j --){
                System.out.print(" ");
            }
            if(i == num - 1){
                for (int k = 0; k < num  ;k ++){
                    System.out.print("* ");
                }
                continue;
            }
            System.out.print("*");
            if(i*2-1 > 0){
                for (int k = 1; k <= i*2-1;k ++){
                    System.out.print(" ");
                }
                System.out.print("*");
            }

            System.out.println();

        }

    }

    public boolean isValid(String s){
        if(s == null){
            throw new NullPointerException("�ַ���Ϊ��");
        }
        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0 ; i < s.length() ; i ++){
            char c = s.charAt(i);
            if(i == 0 && (c == ')' || c == ']' || c == '}')){
                return false;
            }
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                char top = stack.pop();
                if(c == ')' && top != '('){
                    return false;
                }
                if(c == ']' && top != '['){
                    return false;
                }
                if(c == '}' && top != '{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}


abstract class B{//�ⲿ��

    public abstract void A(Stack<Integer> stack);

}

