package com.interviewbit.nonlinear.tree;

import com.interviewbit.nonlinear.util.TreeNode;

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

    public int isBalanced(TreeNode node){
        return isTreeBalanced(node) != -1 ? 1 : -1;
    }


    public int isTreeBalanced(TreeNode node){

        if( node == null) return 0;
        int left = isTreeBalanced(node.left);
        int right = isTreeBalanced(node.right);

        if( left == -1 || right == -1)
            return -1;
        if( Math.abs(left - right) > 1)
            return -1;
        return Math.max(left,right) + 1;
    }
}

