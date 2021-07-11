package com.interviewbit.tree;

import com.interviewbit.utils.TreeNode;
import com.interviewbit.utils.ArrayUtils;

import java.util.Stack;

/*
Problem Description

Given a Binary Tree A containing N nodes.

You need to find the path from Root to a given node B.

NOTE:

No two nodes in the tree have same data values.
You can assume that B is present in the tree A and a path always exists.


Problem Constraints
 1 <= N <= 105

 1 <= Data Values of Each Node <= N

 1 <= B <= N



Input Format
First Argument represents pointer to the root of binary tree A.

Second Argument is an integer B denoting the node number.


 */
public class PathToGivenNode {
    public static void main(String[] args) {

        PathToGivenNode obj = new PathToGivenNode();

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

        int[] ints = obj.solve(root, 15);
        ArrayUtils.printArray(ints);
    }

    public int[] solve(TreeNode A, int B) {

        Stack<Integer> result = new Stack<>();
        inOrder(A, result, B);

        int[] finalResult = new int[result.size()];

        int i = 0;
        while (!result.isEmpty()) {
            finalResult[i++] = result.pop();
        }

        return finalResult;

    }


    public Stack<Integer> inOrder(TreeNode A, Stack<Integer> result, int B) {


        if (A == null) return null;

        if (inOrder(A.left, result, B) != null) {
            result.add(A.val);
            return result;
        }

        if (A.val == B) {
            result.add(A.val);
            return result;
        }

        if (inOrder(A.right, result, B) != null) {
            result.add(A.val);
            return result;
        }

        return null;
    }


    Stack<Integer> stack;

    public int[] solveOptimized(TreeNode A, int B) {
        stack = new Stack<>();
        inOrder(A, B);
        int[] finalResult = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            finalResult[i++] = stack.pop();
        }
        return finalResult;
    }

    public boolean inOrder(TreeNode A, int B) {
        if (A == null) return false;
        boolean left = inOrder(A.left, B);
        if (A.val == B) {
            stack.add(A.val);
            return true;
        }
        boolean right = inOrder(A.right, B);
        boolean result = left || right;
        if (result) stack.push(A.val);
        return result;
    }
}

/*
    Look Copy For Clarification

 */
