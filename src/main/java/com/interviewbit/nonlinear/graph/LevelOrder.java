package com.interviewbit.nonlinear.graph;


import com.interviewbit.nonlinear.tree.BSTIterator;
import com.interviewbit.nonlinear.util.TreeNode;
import com.interviewbit.utils.ArrayUtils;

import java.util.*;

public class LevelOrder {

    public static void main(String[] args) {

        LevelOrder obj = new LevelOrder();

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

        int[][] ints = obj.levelOrder(root);
        ArrayUtils.printArray(ints);
    }

    public int[][] levelOrder(TreeNode A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);

        while (!queue.isEmpty()) {
            int numberOfNodes = queue.size();
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int i = 0; i < numberOfNodes; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
                innerList.add(curr.val);
            }
            result.add(innerList);
        }

        int n = result.size();

        int[][] finalResult = new int[n][];

        int i = 0;
        for (ArrayList<Integer> inner : result) {
            finalResult[i++] = inner.stream().mapToInt(x -> x).toArray();
        }

        return finalResult;

    }
}
