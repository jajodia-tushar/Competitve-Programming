package com.interviewbit.tree;

import com.interviewbit.utils.BTreePrinter;
import com.interviewbit.utils.TreeNode;

/*

Problem Description

Given a binary tree A with N nodes.

You have to remove all the half nodes and return the final binary tree.

NOTE:

Half nodes are nodes which have only one child.
Leaves should not be touched as they have both children as NULL.


Problem Constraints
 1 <= N <= 105



Input Format
First and only argument is an pointer to the root of binary tree A.



Output Format
Return a pointer to the root of the new binary tree.



Example Input
Input 1:

           1
         /   \
        2     3
       /
      4

Input 2:

            1
          /   \
         2     3
        / \     \
       4   5     6

Example Output
Output 1:
           1
         /   \
        4     3
Output 2:
            1
          /   \
         2     6
        / \

       4   5

Example Explanation
Explanation 1:

The only half node present in the tree is 2 so we will remove this node.
Explanation 2:
The only half node present in the tree is 3 so we will remove this node.


 */


public class RemoveHalfNodes {

    public static void main(String[] args) {

        RemoveHalfNodes obj = new RemoveHalfNodes();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(5);


        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.right.left.left = new TreeNode(12);

        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);

        BTreePrinter.printNode(root);
        obj.solve(root);
        BTreePrinter.printNode(root);

    }

    public TreeNode solve(TreeNode A) {
        return solveX(A);
    }

    public TreeNode solveX(TreeNode A) {

        if (A == null) return null;

        A.left = solveX(A.left);
        A.right = solveX(A.right);

        if (A.left == null && A.right != null)
            return A.right;

        if (A.left != null && A.right == null)
            return A.left;
        return A;

    }
}

/*
    LOOK COPY FOR CLARIFICATION
 */