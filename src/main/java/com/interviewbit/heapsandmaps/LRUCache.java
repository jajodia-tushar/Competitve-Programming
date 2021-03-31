package com.interviewbit.heapsandmaps;

import java.util.*;

public class LRUCache {

    public static void main(String[] args) {

        LRU lru = new LRU(2);
        lru.set(2,1);
        lru.set(1,1);
        lru.set(2,3);
        lru.set(4,1);
        System.out.println(lru.get(1));
        System.out.println(lru.get(2));
    }
}

class LRU{

    Deque<Integer> list;
    Map<Integer,Integer> map;
    int size;


    public LRU(int capacity){
        this.list = new LinkedList<>();
        this.map = new HashMap<>();
        this.size = capacity;
    }

    public int get(int key) {

        if(map.containsKey(key)){
            updateLRU(key);
            return map.get(key);
        }
        else{
            return - 1;
        }

    }

    public void set(int key, int value) {

        if(map.containsKey(key)){
            map.put(key,value);
            updateLRU(key);

        }
        else{
            if(this.size == this.list.size()){
                int item = list.removeFirst();
                map.remove(item);
            }
            map.put(key,value);
            list.add(key);
        }
    }

    public void updateLRU(int key){
        list.remove(key);
        list.add(key);
    }
}