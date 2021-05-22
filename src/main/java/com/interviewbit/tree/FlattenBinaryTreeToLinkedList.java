package com.interviewbit.tree;

import com.interviewbit.utils.BTreePrinter;
import com.interviewbit.utils.TreeNode;

public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {

        FlattenBinaryTreeToLinkedList obj = new FlattenBinaryTreeToLinkedList();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);

        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);

        BTreePrinter.printNode(root);
        obj.flatten(root);
        BTreePrinter.printNode(root);
    }

    public TreeNode flatten(TreeNode a) {
        solve(a);
        return a;
    }

    public TreeNode solve(TreeNode node){

        if( node == null) return null;

        if( node.left == null && node.right == null){
            return node;
        }

        TreeNode right = node.right;

        if(node.left != null){
            TreeNode llNode = solve(node.left);
            node.right = llNode;
            while(llNode.right != null){
                llNode = llNode.right;
            }
            llNode.right = right;
            node.left = null;
        }

        if(right != null){
            solve(right);
        }

        return node;
    }
}
