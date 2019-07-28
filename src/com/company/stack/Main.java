package com.company.stack;

public class Main {

    //测试ArrayStack 和LinkedListStack 的性能
    public static void main(String[] args) {
        int opCount = 10000000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time = testStack(arrayStack, opCount);
        System.out.println("AarryStack : " + time + " s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack ,opCount);
        System.out.println("LinkedListStack : " + time2 + " s");
    }

    public static double testStack(Stack<Integer> stack,int opCount){
        long startTime = System.nanoTime();
        for (int i = 0; i < opCount; i++) {
            stack.push(i);
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) /1000000000.0;
    }
}
