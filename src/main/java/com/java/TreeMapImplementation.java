package com.java;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapImplementation {

    public static void main(String[] args) {

        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        treeMap.put(1,10);
        treeMap.put(20,30);
        treeMap.put(35,80);
        treeMap.put(100,120);//

        Map.Entry<Integer, Integer> integerIntegerEntry = treeMap.higherEntry(25);
        System.out.println(integerIntegerEntry.getValue());

    }
}
