package com.interviewbit.tree;

import com.interviewbit.utils.TreeNode;

import java.util.ArrayList;

public class PreOrderTraversal {

    public static void main(String[] args) {

        PreOrderTraversal obj = new PreOrderTraversal();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        ArrayList<Integer> result = new ArrayList<>();
        obj.traverse(root,result);
        System.out.println(result);
    }

    public static void traverse(TreeNode node, ArrayList<Integer> result){
        if( node == null) return;
        result.add(node.val);
        traverse(node.left,result);
        traverse(node.right,result);
    }



}
