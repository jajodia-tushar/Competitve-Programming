package com.interviewbit.tree;

import com.interviewbit.utils.TreeNode;

public class FindTheHeightOfBST {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        FindTheHeightOfBST obj = new FindTheHeightOfBST();
        System.out.println(obj.findHeight(root));
    }

    public int findHeight(TreeNode node){
        if( node == null)
            return -1;

        int left = findHeight(node.left);
        int right = findHeight(node.right);

        if(left > right){
            return left + 1;
        }
        else
            return right + 1;
    }
}
