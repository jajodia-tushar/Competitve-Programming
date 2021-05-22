package com.interviewbit.tree;

import com.interviewbit.utils.BTreePrinter;
import com.interviewbit.utils.TreeNode;

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

    public TreeNode solveX(TreeNode A){

        if( A == null) return null;

        A.left = solveX(A.left);
        A.right = solveX(A.right);

        if( A.left == null && A.right != null)
            return A.right;

        if( A.left != null && A.right == null)
            return A.left;
        return A;

    }
}
