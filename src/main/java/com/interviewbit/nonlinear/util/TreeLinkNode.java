package com.interviewbit.nonlinear.util;

import java.util.LinkedList;

public class TreeLinkNode {
    public int val;
    public TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }

    public static TreeLinkNode createTreeFromArray(int ...arr){

        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        TreeLinkNode root = new TreeLinkNode(arr[0]);

        queue.addFirst(root);
        int i = 1;
        while(!queue.isEmpty()){
            TreeLinkNode currentNode = queue.removeLast();

            int item = arr[i++];
            if(item != -1){
                currentNode.left = new TreeLinkNode(item);
                queue.addFirst(currentNode.left);
            }
            item = arr[i++];

            if(item != -1){
                currentNode.right = new TreeLinkNode(item);
                queue.addFirst(currentNode.right);
            }
        }
        return root;
    }
}
