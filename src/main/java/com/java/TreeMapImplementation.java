package com.java;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMapImplementation {

    public static void main(String[] args) {

        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        treeMap.put(1,10);
        treeMap.put(20,30);
        treeMap.put(35,80);
        treeMap.put(100,120);//

        Map.Entry<Integer, Integer> integerIntegerEntry = treeMap.higherEntry(25);
        System.out.println(integerIntegerEntry.getValue());

        System.out.println("-----------------------------");
        TreeSet<Integer> sets = new TreeSet<>();

        sets.add(1);
        sets.add(2);
        sets.add(3);
        sets.add(4);
        sets.add(5);
        sets.add(6);
        sets.add(7);
        sets.add(8);
        sets.add(9);
        sets.add(10);
        sets.add(11);
        sets.add(12);

        System.out.println(sets.first());
        System.out.println(sets.last());
        System.out.println(sets.lower(5));
        System.out.println(sets.higher(5));
        System.out.println(sets.floor(5));
        System.out.println(sets.ceiling(5));


    }
}
