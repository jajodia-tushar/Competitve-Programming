package com.interviewbit.tree;

import com.interviewbit.utils.TreeNode;

import java.util.ArrayList;

public class InorderTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        ArrayList<Integer> result = new ArrayList<>();
        traverse(root, result);
        System.out.println(result);

        TreeNode nextRoot = new TreeNode(10);
        nextRoot.left = new TreeNode(5);
        nextRoot.right = new TreeNode(30);

        nextRoot.left.left = new TreeNode(-2);
        nextRoot.left.right = new TreeNode(6);

        nextRoot.left.left.right = new TreeNode(2);
        nextRoot.left.left.right.left = new TreeNode(-1);

        nextRoot.left.right = new TreeNode(6);
        nextRoot.left.right.right = new TreeNode(8);

        nextRoot.right = new TreeNode(30);
        nextRoot.right.right = new TreeNode(40);
        morrisInOrderTraversal(nextRoot);
    }

    public static void traverse(TreeNode node, ArrayList<Integer> result) {
        if (node == null) return;
        traverse(node.left, result);
        result.add(node.val);
        traverse(node.right, result);
    }

    public static void morrisInOrderTraversal(TreeNode node) {

        TreeNode current = node;

        while( current != null){
            if(current.left == null){
                System.out.print(current.val +" ");
                current = current.right;
            }
            else{
                TreeNode predecessor = findPredecessor(current);
                if( predecessor.right == null){
                    predecessor.right = current;
                    current = current.left;
                }
                else{
                    predecessor.right = null;
                    System.out.print(current.val +" ");
                    current = current.right;
                }
            }
        }
    }

    public static TreeNode findPredecessor(TreeNode node) {

        TreeNode predecessor = node.left;
        while (predecessor.right != null && predecessor.right != node) {
            predecessor = predecessor.right;
        }
        return predecessor;
    }


}