package com.interviewbit.tree;

/*

Problem Description
    Given two Binary Trees A and B, you need to merge them in a single binary tree.
    The merge rule is that if two nodes overlap, then sum of node values is the new value of the merged node.
    Otherwise, the non-null node will be used as the node of new tree.

    Problem Constraints
    1 <= Number of Nodes in A , B <= 105

    Input Format
    First argument is an pointer to the root of binary tree A.

    Second argument is an pointer to the root of binary tree B.

    Output Format
    Return a pointer to the root of new binary tree.

    Example Input
    Input 1:

     A =   2

          / \

         1   4

        /

       5


    B =   3
          / \
          6  1
          \   \
           2   7

    Input 2:

     A =   12

          / \

         11  14


    B =   3
          / \
          6  1



    Example Output
    Output 1:

         5
        / \
       7   5
      / \   \
     5   2   7
    Output 2:

       15
      / \
     17  15


    Example Explanation
    Explanation 1:

     After merging both the trees you get:
         5
        / \
       7   5
      / \   \
     5   2   7
    Explanation 2:

     After merging both the trees we get:
       15
      / \
     17  15

 */

import com.interviewbit.linkedlist.MergeTwoSortedLists;
import com.interviewbit.utils.TreeNode;

public class MergeTwoBinaryTree {

    public static void main(String[] args) {

        MergeTwoBinaryTree obj = new MergeTwoBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);
        root.left.left.left.left.left = new TreeNode(6);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(8);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(10);
        root.right.right.right.right = new TreeNode(11);
        root.right.right.right.right.right = new TreeNode(12);
        root.right.left = new TreeNode(13);

        TreeNode result = obj.solve(root, root);
    }

    public TreeNode solve(TreeNode A, TreeNode B) {

        if (A == null && B == null) return null;

        if (A == null) return B;
        if (B == null) return A;

        A.left = solve(A.left, B.left);
        A.right = solve(A.right, B.right);

        A.val += B.val;
        return A;
    }
}

/*
    Easy Very Easy.


 */
