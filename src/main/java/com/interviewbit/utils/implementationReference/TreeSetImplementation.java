package com.interviewbit.utils.implementationReference;

import java.util.TreeSet;

public class TreeSetImplementation {

    public static void main(String[] args) {


//        TreeSet<Integer> treeSet = new TreeSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>((x,y)->y.compareTo(x));
        treeSet.add(1);
        treeSet.add(10);
        treeSet.add(2);
        treeSet.add(20);
        treeSet.add(30);


        System.out.println(treeSet);
        System.out.println(treeSet.first());
        System.out.println(treeSet.last());
        System.out.println(treeSet.lower(5));
        System.out.println(treeSet.ceiling(19));

    }
}
