package com.interviewbit.tree;

import com.interviewbit.utils.ArrayUtils;
import com.interviewbit.utils.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversal {

    public static void main(String[] args) {

        PreOrderTraversal obj = new PreOrderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int[] result = obj.preorderTraversal(root);
        ArrayUtils.printArray(result);

    }

    public static void traverse(TreeNode node, ArrayList<Integer> result) {
        if (node == null) return;
        result.add(node.val);
        traverse(node.left, result);
        traverse(node.right, result);
    }

    public int[] preorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        traverseIterative(A, result);
        return result.stream().mapToInt(x -> x).toArray();
    }

    public void traverseIterative(TreeNode A, ArrayList<Integer> result) {
        if (A == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);
        result.add(A.val);
        A = A.left;
        while (!stack.isEmpty()) {
            A = stack.pop();
            A = A.right;
            while (A != null) {
                result.add(A.val);
                stack.push(A);
                A = A.left;
            }
        }
    }
}
