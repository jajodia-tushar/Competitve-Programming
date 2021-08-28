package com.interviewbit.heapsandmaps;

import java.util.*;

/*
Design and implement a data structure for LRU (Least Recently Used) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
The LRU Cache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.

Definition of “least recently used” : An access to an item is defined as a get or a set operation of the item. “Least recently used” item is the one with the oldest access time.

 NOTE: If you are using any global variables, make sure to clear them in the constructor.
Example :

Input :
         capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full.
         get(5)        returns -1
 */
public class LRUCache {

    Map<Integer, Integer> map;
    LinkedList<Integer> queue;
    int capacity;
    int currCapacity;

    public static void main(String[] args) {

        LRU lru = new LRU(2);
        lru.set(2, 1);
        lru.set(1, 1);
        lru.set(2, 3);
        lru.set(4, 1);
        System.out.println(lru.get(1));
        System.out.println(lru.get(2));
    }


    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.queue = new LinkedList<>();
        this.capacity = capacity;
        this.currCapacity = 0;
    }

    public int get(int key) {
        if (this.map.containsKey(key)) {
            int value = this.map.get(key);
            this.queue.remove((Integer) key);
            this.queue.add(key);
            return value;
        }
        return -1;
    }

    public void set(int key, int value) {

        if (this.map.containsKey(key)) {
            this.map.put(key, value);
            this.queue.remove((Integer) key);
            this.queue.add(key);
        } else if (currCapacity < capacity) {
            this.map.put(key, value);
            this.queue.add(key);
            currCapacity++;
        } else {
            int rKey = this.queue.removeFirst();
            this.map.remove(rKey);
            this.queue.add(key);
            this.map.put(key, value);
        }
    }
}

class LRU {

    Deque<Integer> list;
    Map<Integer, Integer> map;
    int size;


    public LRU(int capacity) {
        this.list = new LinkedList<>();
        this.map = new HashMap<>();
        this.size = capacity;
    }

    public int get(int key) {

        if (map.containsKey(key)) {
            updateLRU(key);
            return map.get(key);
        } else {
            return -1;
        }

    }

    public void set(int key, int value) {

        if (map.containsKey(key)) {
            map.put(key, value);
            updateLRU(key);

        } else {
            if (this.size == this.list.size()) {
                int item = list.removeFirst();
                map.remove(item);
            }
            map.put(key, value);
            list.add(key);
        }
    }

    public void updateLRU(int key) {
        list.remove(key);
        list.add(key);
    }
}

class LRUCacheLeetCode {

    Map<Integer, ListNode> maps;
    ListNode head;
    ListNode tail;
    int capacity;

    public LRUCacheLeetCode(int capacity) {
        this.maps = new HashMap<>();
        this.head = new ListNode();
        this.tail = new ListNode();
        this.capacity = capacity;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {

        if (this.maps.containsKey(key)) {
            ListNode node = this.maps.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {

        if (this.maps.containsKey(key)) {
            ListNode node = this.maps.get(key);
            remove(node);
        } else if (this.maps.size() < this.capacity) {
            ListNode node = new ListNode(key, value);
        } else {
            remove(this.tail.prev);
        }
        insert(new ListNode(key, value));
    }

    public void insert(ListNode node) {
        this.maps.put(node.key, node);
        ListNode headNext = this.head.next;
        this.head.next = node;
        node.next = headNext;
        headNext.prev = node;
        node.prev = this.head;
    }

    public void remove(ListNode node) {
        this.maps.remove(node.key);
        ListNode pre = node.prev;
        ListNode nex = node.next;
        pre.next = nex;
        nex.prev = pre;
    }


    static class ListNode {
        public ListNode prev;
        public ListNode next;
        public int key;
        public int value;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }

        public ListNode() {
            this(-1, -1);
        }
    }
}

/*
    Use Map to Store Key Value Pair.
    And Use LinkedList ( Doubly Linked List) to store all LRU.
    Insert from One Side and Delete from Other Side.

    If there is a Access Case, then remove that particular value
    from LinkedList O(n) and then add in the start of the List
    No need to do anything in the Map.

    There is a special. Case of Value Update.
    If a key is already present in the map, then update in Map
    and remove the key from LinkedList and Add to first as well.

 */