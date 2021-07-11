package com.interviewbit.tree;

import com.interviewbit.utils.TreeNode;

/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

Example :

    1
   / \
  2   2
 / \ / \
3  4 4  3
The above binary tree is symmetric.

But the following is not:

    1
   / \
  2   2
   \   \
   3    3
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class SymmetricBinaryTree {

    public static void main(String[] args) {

        SymmetricBinaryTree obj = new SymmetricBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(3);

        System.out.println(obj.isSymmetric(root));

    }

    public int isSymmetric(TreeNode A) {
        return isMirror(A, A) ? 1 : 0;
    }

    public boolean isMirror(TreeNode firstNode, TreeNode secondNode) {

        if (firstNode == null && secondNode == null)
            return true;


        if ((firstNode != null && secondNode != null) &&
                (firstNode.val == secondNode.val))
            return isMirror(firstNode.left, secondNode.right) &&
                    isMirror(firstNode.right, secondNode.left);


        return false;

    }
}

/*
    Easy,
    Just Remember to pass two variables.
    With One it's not possible
 */