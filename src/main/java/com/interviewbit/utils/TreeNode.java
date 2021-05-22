package com.interviewbit.utils;

import java.util.ArrayList;
import java.util.LinkedList;

public class TreeNode {

    public static int VERTICAL_SPACE = 10;
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public static void inOrderPrint(TreeNode node){
        if( node == null) return;
        inOrderPrint(node.left);
        System.out.print(node.val +"  ");
        inOrderPrint(node.right);
    }

    public static void preOrderPrint(TreeNode node){
        if( node == null) return;
        System.out.print(node.val +"  ");
        preOrderPrint(node.left);
        preOrderPrint(node.right);
    }

    public static void postOrderPrint(TreeNode node){
        if( node == null) return;
        postOrderPrint(node.left);
        postOrderPrint(node.right);
        System.out.print(node.val +"  ");
    }

    public static void getInOrder(TreeNode node,ArrayList<Integer> result){
        if( node == null) return;
        getInOrder(node.left,result);
        result.add(node.val);
        getInOrder(node.right,result);
    }

    public static void getPreOrder(TreeNode node,ArrayList<Integer> result){
        if( node == null) return;
        result.add(node.val);
        getPreOrder(node.left,result);
        getPreOrder(node.right,result);
    }

    public static void getPostOrder(TreeNode node, ArrayList<Integer> result){
        if( node == null) return;
        getPostOrder(node.left,result);
        getPostOrder(node.right,result);
        result.add(node.val);
    }

    public static TreeNode createTreeFromArray(int ...arr){

        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);

        queue.addFirst(root);
        int i = 1;
        while(!queue.isEmpty()){
            TreeNode currentNode = queue.removeLast();

            int item = arr[i++];
            if(item != -1){
                currentNode.left = new TreeNode(item);
                queue.addFirst(currentNode.left);
            }
            item = arr[i++];

            if(item != -1){
                currentNode.right = new TreeNode(item);
                queue.addFirst(currentNode.right);
            }
        }
        return root;
    }

    public static void printTree(TreeNode root, int space) {

        if (root == null)
            return;
        space += VERTICAL_SPACE;
        printTree(root.right, space);
        System.out.print("\n");
        for (int i = VERTICAL_SPACE; i < space; i++)
            System.out.print(" ");
        System.out.print(root.val + "\n");
        printTree(root.left, space);
    }

    public static void printBinaryTree(TreeNode root, int level){
        if(root==null)
            return;
        printBinaryTree(root.right, level+1);
        if(level!=0){
            for(int i=0;i<level-1;i++)
                System.out.print("|\t");
            System.out.println("|-------"+root.val);
        }
        else
            System.out.println(root.val);
        printBinaryTree(root.left, level+1);
    }

    public TreeNode constructBSTFromInOrder(int[] arr){
        return null;
    }

    public TreeNode constructBSTFromPreOrder(int[] arr){
        return null;
    }

    public TreeNode constructBSTFromPostOrder(int[] arr){
        return null;
    }

}
