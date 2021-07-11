package com.interviewbit.tree;

import com.interviewbit.utils.TreeNode;

/*
Given a binary tree, determine if it is height-balanced.

Height-balanced binary tree  : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Example :

Input :
          1
         / \
        2   3

Return : True or 1

Input 2 :
         3
        /
       2
      /
     1

Return : False or 0
         Because for the root node, left subtree has depth 2 and right subtree has depth 0.
         Difference = 2 > 1.
 */


// SEE AGAIN
public class BalancedBinaryTree {

    public static void main(String[] args) {

        BalancedBinaryTree obj = new BalancedBinaryTree();
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

        System.out.println(obj.isBalanced(root));

    }

    public int isBalanced(TreeNode node) {
        return isTreeBalanced(node) != -1 ? 1 : -1;
    }


    public int isTreeBalanced(TreeNode node) {

        if (node == null) return 0;
        int left = isTreeBalanced(node.left);
        int right = isTreeBalanced(node.right);

        if (left == -1 || right == -1)
            return -1;
        if (Math.abs(left - right) > 1)
            return -1;
        return Math.max(left, right) + 1;
    }
}

/*
    Amazing Technique in Optimized Version


 */