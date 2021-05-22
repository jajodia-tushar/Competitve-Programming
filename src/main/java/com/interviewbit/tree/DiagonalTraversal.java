package com.interviewbit.tree;

import com.interviewbit.utils.TreeNode;
import com.interviewbit.utils.ArrayUtils;

import java.util.*;

public class DiagonalTraversal {

    public static void main(String[] args) {

        DiagonalTraversal obj = new DiagonalTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);

        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);

        int[] ints = obj.solve(root);
        ArrayUtils.printArray(ints);
    }

    public int[] solve(TreeNode A) {

        Map<Integer, ArrayList<Integer>> maps = new TreeMap<>();
        traverse(A, maps, 0);

        return maps.values()
                .stream()
                .flatMapToInt(x -> x.stream().mapToInt(y -> y))
                .toArray();
    }

    public void traverse(TreeNode node, Map<Integer, ArrayList<Integer>> maps, int diagonal) {


        if (node == null) return;
        if (maps.containsKey(diagonal)) {
            maps.get(diagonal).add(node.val);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.val);
            maps.put(diagonal, list);
        }

        traverse(node.left, maps, diagonal + 1);
        traverse(node.right, maps, diagonal);
    }
}
