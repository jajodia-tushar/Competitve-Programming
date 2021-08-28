package com.interviewbit.greedy;

import java.util.*;

public class HuffManCoding {

    public static void main(String[] args) {

        Map<Character, Integer> maps = new HashMap<>();
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] charfreq = {5, 9, 12, 13, 16, 45};

        HuffManCoding obj = new HuffManCoding();
        obj.createMap(charArray, charfreq, maps);
        HuffManNode root = obj.buildHuffManTree(maps);
        obj.printHuffManCode(root, "");

    }

    public void createMap(char[] chars, int[] ints, Map<Character, Integer> map) {
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            map.put(chars[i], ints[i]);
        }
    }


    public HuffManNode buildHuffManTree(Map<Character, Integer> characterIntegerMap) {

        PriorityQueue<HuffManNode> heap = new PriorityQueue<>((a, b) -> a.data - b.data);
        for (Map.Entry<Character, Integer> entry : characterIntegerMap.entrySet())
            heap.add(new HuffManNode(entry.getValue(), entry.getKey()));

        while (heap.size() > 1) {

            HuffManNode currNode = heap.poll();
            HuffManNode nextNode = heap.poll();

            HuffManNode newNode = new HuffManNode();
            newNode.data = currNode.data + nextNode.data;
            newNode.left = currNode;
            newNode.right = nextNode;
            newNode.ch = '-';
            heap.add(newNode);
        }
        return heap.poll();
    }

    public void printHuffManCode(HuffManNode root, String soFar) {
        if (root == null) return;

        if (root.left == null && root.right == null)
            System.out.println(root.ch + " -> " + soFar);
        printHuffManCode(root.left, soFar + "0");
        printHuffManCode(root.right, soFar + "1");
    }

    static class HuffManNode {
        int data;
        char ch;
        HuffManNode left;
        HuffManNode right;

        public HuffManNode() {
        }

        public HuffManNode(int data, char ch) {
            this.data = data;
            this.ch = ch;
        }
    }
}
