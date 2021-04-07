package com.interviewbit.nonlinear.tree;

import com.interviewbit.nonlinear.util.BTreePrinter;
import com.interviewbit.nonlinear.util.TreeNode;

public class InvertTheBinaryTree {
    public static void main(String[] args) {

        InvertTheBinaryTree obj = new InvertTheBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);

        BTreePrinter.printNode(root);
        obj.invertTree(root);
        BTreePrinter.printNode(root);
    }

    public TreeNode invertTree(TreeNode A) {
        reverse(A);
        return A;
    }

    public void reverse(TreeNode A){

        if( A == null) return;

        reverse(A.left);
        reverse(A.right);

        TreeNode temp = A.left;
        A.left = A.right;
        A.right = temp;
    }

}
