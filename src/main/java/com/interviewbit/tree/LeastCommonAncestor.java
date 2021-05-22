package com.interviewbit.tree;

import com.interviewbit.utils.TreeNode;

public class LeastCommonAncestor {

    public boolean first = false;
    public boolean second = false;

    public static void main(String[] args) {

        LeastCommonAncestor obj = new LeastCommonAncestor();
        TreeNode root = new TreeNode(1);
        System.out.println(obj.lca(root,1,1));
    }

    public int lca(TreeNode A, int B, int C) {

        int value = findLCA(A,B,C);
        return first && second ? value : -1;
    }


    int findLCA(TreeNode node, int n1, int n2)
    {
        if (node == null)
            return -1;

        if (node.val == n1 || node.val == n2){
            if( node.val == n1) first = true;
            if( node.val == n2) second = true;
            return node.val;
        }

        int left_lca = findLCA(node.left, n1, n2);
        int right_lca = findLCA(node.right, n1, n2);

        if (left_lca != -1 && right_lca != -1)
            return node.val;

        return (left_lca != -1) ? left_lca : right_lca;
    }
}
