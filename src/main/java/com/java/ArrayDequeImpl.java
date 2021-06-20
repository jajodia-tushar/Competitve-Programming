package com.java;

import java.util.ArrayDeque;

public class ArrayDequeImpl {

    public static void main(String[] args) {

        ArrayDeque<Integer> obj = new ArrayDeque<>();

        obj.add(10);
        obj.add(20);
        obj.add(30);
        System.out.println(obj.peek());
        obj.addFirst(40);
        System.out.println(obj.peek());
        obj.addLast(50);
        System.out.println(obj.peek());


    }
}
