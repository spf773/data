package com.company;

import com.company.array.Array;

public class Student {

    private String name;

    private int score;

    public Student(){

    }

    public Student(String name,int score){
        this.name = name;
        this.score = score;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args){
        Array<Student> arrays = new Array<>();

        arrays.addLast(new Student("Alice",100));
        arrays.addLast(new Student("Bob",90));
        arrays.addLast(new Student("Bob",90));
        arrays.addLast(new Student("Tom",95));
        arrays.addLast(new Student("Jack",80));
        System.out.println(arrays);
        System.out.println("--------------");
        arrays.removeLast();
        System.out.println(arrays);
        System.out.println("--------------");
        arrays.addLast(new Student("Jack",80));
        System.out.println(arrays);
        System.out.println("--------------");
        arrays.removeFirst();
        System.out.println(arrays);
        System.out.println("--------------");
        System.out.println(arrays.contains(new Student("Bob",90)));
        System.out.println("--------------");
        arrays.removeElement(new Student("Bob",90));
        System.out.println(arrays);


    }
}
