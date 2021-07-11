package com.interviewbit.tree;

import com.interviewbit.utils.TreeNode;

/*
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Example :

Input :

   1       1
  / \     / \
 2   3   2   3

Output :
  1 or True
 */
public class IdenticalBinaryTrees {

    public static void main(String[] args) {

        IdenticalBinaryTrees obj = new IdenticalBinaryTrees();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(3);

        System.out.println(obj.isSame(root, root));
    }

    public int isSameTree(TreeNode A, TreeNode B) {

        return isSame(A, B) ? 1 : 0;

    }

    public boolean isSame(TreeNode A, TreeNode B) {

        if (A == null && B == null)
            return true;

        if (A.val == B.val)
            return isSame(A.left, B.left) && isSame(A.right, B.right);

        return false;
    }
}

/*
    Easy
 */