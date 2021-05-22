package com.interviewbit.tree;

import com.interviewbit.utils.TreeNode;

public class KthSmallestElementInTree {

    int res = 0;
    int k = 0;

    public static void main(String[] args) {

        KthSmallestElementInTree obj = new KthSmallestElementInTree();
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
        System.out.println(obj.kthsmallest(root,4));

    }

    public int kthsmallest(TreeNode A, int B) {
        findKthSmallestNumber(A,B);
        return res;
    }

    private void findKthSmallestNumber(TreeNode node, int b) {

        if( node == null) return;

        findKthSmallestNumber(node.left,b);
        k++;
        if( k == b) res = node.val;
        findKthSmallestNumber(node.right,b);
    }


}
