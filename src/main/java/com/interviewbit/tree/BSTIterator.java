package com.interviewbit.tree;


/*

Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
The first call to next() will return the smallest number in BST. Calling next() again will return the next smallest number in the BST, and so on.
 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
Try to optimize the additional space complexity apart from the amortized time complexity.

 */

import com.interviewbit.utils.TreeNode;

import java.util.Stack;


public class BSTIterator {

    Stack<TreeNode> stack;

    public static void main(String[] args) {
        BSTIterator obj = new BSTIterator();

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

        obj.solution(root);
        while (obj.hasNext()) {
            System.out.println(obj.next());
        }
    }

    public void solution(TreeNode root) {

        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {

        TreeNode currNode = stack.pop();
        TreeNode next = currNode.right;
        while (next != null) {
            this.stack.push(next);
            next = next.left;
        }
        return currNode.val;
    }
}

/*
    Look Copy
 */

