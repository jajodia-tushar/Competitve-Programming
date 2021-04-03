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

        long oStart = System.currentTimeMillis();
        System.out.println(obj.isBalanced(root));
        System.out.println("UnOptimized call finished in " + (System.currentTimeMillis() - oStart));
        System.out.println();
        long iStart = System.currentTimeMillis();
        System.out.println(obj.isBalancedOptimized(root).isBalanced);
        System.out.println("Optimized call finished in " + (System.currentTimeMillis() - iStart));

    }

    public boolean isBalanced(TreeNode node){

        if( node == null) return true;
        boolean isLeftSubTreeBalanced = isBalanced(node.left);
        boolean isRightSubTreeBalanced = isBalanced(node.right);
        int left = findHeight(node.left);
        int right = findHeight(node.right);
        int diff = left - right;

        return diff <= 1
                && isLeftSubTreeBalanced && isRightSubTreeBalanced;
    }

    public BalancedPair isBalancedOptimized(TreeNode node){

        if(node == null){
            BalancedPair balancedPair  = new BalancedPair();
            balancedPair.height = -1;
            balancedPair.isBalanced = true;
            return balancedPair;
        }

        BalancedPair leftBalancedPair = isBalancedOptimized(node.left);
        BalancedPair rightBalancedPair = isBalancedOptimized(node.right);
        boolean isLeftBalanced = leftBalancedPair.isBalanced;
        boolean isRightBalanced = rightBalancedPair.isBalanced;
        int leftHeight = leftBalancedPair.height;
        int rightHeight = rightBalancedPair.height;

        BalancedPair currentBalancedPair = new BalancedPair();
        currentBalancedPair.height = Math.max(leftHeight, rightHeight) + 1;
        currentBalancedPair.isBalanced = isLeftBalanced && isRightBalanced && Math.abs(leftHeight - rightHeight) <= 1;

        return currentBalancedPair;
    }



    public int findHeight(TreeNode node){

        if(node == null) return -1;
        int left =  findHeight(node.left);
        int right = findHeight(node.right);
        return Math.max(left,right) + 1;
    }
}


class BalancedPair{
    public int height;
    public boolean isBalanced;
}
