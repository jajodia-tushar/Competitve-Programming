package com.interviewbit.tree;

import com.interviewbit.utils.TreeNode;

import java.util.*;

/*

Given a binary search tree T, where each node contains a positive integer, and an integer K, you have to find whether or not there exist two different nodes A and B such that A.value + B.value = K.

Return 1 to denote that two such nodes exist. Return 0, otherwise.

Notes

Your solution should run in linear time and not take memory more than O(height of T).
Assume all values in BST are distinct.
Example :

Input 1:

T :       10
         / \
        9   20

K = 19

Return: 1

Input 2:

T:        10
         / \
        9   20

K = 40

Return: 0


 */

//SEEAGAIN
public class TwoSumBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(25);

        root.left = new TreeNode(20);
        root.right = new TreeNode(36);

        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(22);

        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(12);

        root.right.left = new TreeNode(30);
        root.right.left.left = new TreeNode(28);

        root.right.right = new TreeNode(40);
        root.right.right.left = new TreeNode(38);
        root.right.right.right = new TreeNode(48);

        TwoSumBinaryTree obj = new TwoSumBinaryTree();
        System.out.println(obj.t2Sum(root, 500));
    }

    Stack<TreeNode> stack1;
    Stack<TreeNode> stack2;


    public int t2Sum(TreeNode A, int B) {

        stack1 = new Stack<>();
        stack2 = new Stack<>();

        TreeNode left = A;
        TreeNode right = A;

        while (left != null) {
            stack1.push(left);
            left = left.left;
        }

        while (right != null) {
            stack2.push(right);
            right = right.right;
        }


        left = inOrder(stack1);
        right = rInOrder(stack2);

        while (left != null && right != null && left != right) {
            // System.out.println(left.val + " -- " + right.val);
            int sum = left.val + right.val;
            if (sum > B) {
                right = rInOrder(stack2);
            } else if (sum < B) {
                left = inOrder(stack1);
            } else {
                return 1;
            }
        }

        return 0;
    }

    public TreeNode inOrder(Stack<TreeNode> stack) {

        if (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            TreeNode curr = node.right;

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            return node;
        }
        return null;
    }


    public TreeNode rInOrder(Stack<TreeNode> stack) {

        if (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            TreeNode curr = node.left;

            while (curr != null) {
                stack.push(curr);
                curr = curr.right;
            }
            return node;
        }
        return null;
    }
}

/*
    Look Copy

 */