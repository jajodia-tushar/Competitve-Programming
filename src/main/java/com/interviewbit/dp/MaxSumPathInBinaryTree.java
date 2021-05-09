package com.interviewbit.dp;

import com.interviewbit.nonlinear.util.TreeNode;

public class MaxSumPathInBinaryTree {

    public int maxTillNow = Integer.MIN_VALUE;

    public static void main(String[] args) {

        MaxSumPathInBinaryTree obj = new MaxSumPathInBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int result = obj.calculateSum(root);
        System.out.println(result);

    }

    public int maxPathSum(TreeNode A) {
        calculateSum(A);
        return maxTillNow;
    }

    public int calculateSum(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int left = calculateSum(node.left);
        int right = calculateSum(node.right);

        int ms = Math.max(node.val + Math.max(left, right), node.val);
        int m12 = Math.max(left + node.val + right, ms);

        maxTillNow = Math.max(maxTillNow, m12);
        return maxTillNow;
    }
}
