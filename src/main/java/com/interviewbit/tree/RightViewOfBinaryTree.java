package com.interviewbit.tree;

import com.interviewbit.utils.TreeNode;
import com.interviewbit.utils.ArrayUtils;

import java.util.*;

public class RightViewOfBinaryTree {

    Map<Integer, ArrayList<Integer>> maps;

    public static void main(String[] args) {

        RightViewOfBinaryTree obj = new RightViewOfBinaryTree();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(30);

        root.left.left = new TreeNode(-2);
        root.left.right = new TreeNode(-1);

        root.left.left.right = new TreeNode(2);
        root.left.left.right.left = new TreeNode(6);

        root.left.right.right = new TreeNode(8);

        root.right = new TreeNode(30);
        root.right.right = new TreeNode(40);

        int[] ints = obj.solve(root);
        ArrayUtils.printArray(ints);
    }


    public int[] solve(TreeNode A) {

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        queue.add(A);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 1; i <= size; i++) {
                TreeNode current = queue.poll();
                if (i == size) result.add(current.val);
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
        return result.stream().mapToInt(x -> x).toArray();
    }


    // Look Above For Optimized
//    public int[] solve(TreeNode A) {
//        maps = new TreeMap<>();
//        traverse(A, 0);
//        int result[] = new int[maps.size()];
//        int i = 0;
//        for (ArrayList<Integer> list : maps.values()) {
//            result[i++] = list.get(list.size() - 1);
//        }
//        return result;
//    }
//
//
//    // Not Optimized;
//    public void traverse(TreeNode node, int depth) {
//
//        if (node == null) return;
//        traverse(node.left, depth + 1);
//        traverse(node.right, depth + 1);
//
//        if (maps.containsKey(depth)) {
//            maps.get(depth).add(node.val);
//        } else {
//            ArrayList<Integer> list = new ArrayList<>();
//            list.add(node.val);
//            maps.put(depth, list);
//        }
//
//    }
}
