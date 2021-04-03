package com.interviewbit.nonlinear.tree;

import com.interviewbit.nonlinear.util.TreeNode;
import com.interviewbit.utils.ArrayUtils;

import java.util.*;
import java.util.stream.Collectors;

public class VerticalOrderTraversalOfBinaryTree {

    Map<Integer, ArrayList<Pair>> maps = null;

    public static void main(String[] args) {

        VerticalOrderTraversalOfBinaryTree obj = new VerticalOrderTraversalOfBinaryTree();
        TreeNode root = TreeNode.createTreeFromArray(460, 3871, 4698, 8399, 504, 4421, 7515, -1, 4167, 5727, -1, -1, 3096, 434, 7389, 2667, 5661, 1969, 7815, 4292, 3006, 9750, 6693, -1, 6906, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1);
        int[][] ints = obj.verticalOrderTraversal(root);
        ArrayUtils.printArray(ints);

    }


    public int[][] verticalOrderTraversal(TreeNode A) {

        maps = new TreeMap<>();
        Map<Integer, HashSet<Integer>> map = new TreeMap<>();
        traverse(A, 0, 0);
        int[][] result = new int[maps.size()][];
        int i = 0;
        System.out.println(maps);
        for (ArrayList<Pair> listOfPairs : maps.values()) {
            result[i] = new int[listOfPairs.size()];
            Collections.sort(listOfPairs);
            for (int j = 0; j < listOfPairs.size(); j++) {
                result[i][j] = listOfPairs.get(j).value;
            }
            i++;
        }

        return result;
    }


    public void traverse(TreeNode A, int diversion, int elevation) {


        if (A == null) return;
        traverse(A.left, diversion - 1, elevation + 1);

        Pair newPair = new Pair();
        newPair.value = A.value;
        newPair.elevation = elevation;

        if (maps.containsKey(diversion)) {
            maps.get(diversion).add(newPair);
        } else {
            ArrayList<Pair> list = new ArrayList<>();
            list.add(newPair);
            maps.put(diversion, list);
        }

        traverse(A.right, diversion + 1, elevation + 1);

    }
}

class Pair implements Comparable<Pair> {

    public int value;
    public int elevation;

    public Pair() {
    }

    public Pair(int value, int elevation) {
        this.value = value;
        this.elevation = elevation;
    }

    @Override
    public int compareTo(Pair next) {
        return Integer.compare(this.elevation, next.elevation);
    }
}