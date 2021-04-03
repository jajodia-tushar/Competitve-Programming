package com.interviewbit.nonlinear.tree;

import com.interviewbit.nonlinear.util.TreeNode;

import java.util.ArrayList;

public class PostOrderTraversal {

    public static void main(String[] args) {

        PostOrderTraversal obj = new PostOrderTraversal();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        ArrayList<Integer> result = new ArrayList<>();
        obj.traverse(root, result);
        System.out.println(result);
    }

    public void traverse(TreeNode node, ArrayList<Integer> result) {
        if (node == null) return;
        traverse(node.left, result);
        traverse(node.right, result);
        result.add(node.val);
    }
}

