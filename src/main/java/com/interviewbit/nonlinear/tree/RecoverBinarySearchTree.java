package com.interviewbit.nonlinear.tree;

import com.interviewbit.nonlinear.util.TreeNode;
import com.interviewbit.utils.ArrayUtils;

import static com.interviewbit.nonlinear.tree.InorderTraversal.findPredecessor;

public class RecoverBinarySearchTree {

    TreeNode first;
    TreeNode second;
    TreeNode pre;

    public static void main(String[] args) {
        RecoverBinarySearchTree obj = new RecoverBinarySearchTree();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(30);

        root.left.left = new TreeNode(-2);
        root.left.right = new TreeNode(-1);

        root.left.left.right = new TreeNode(2);
        root.left.left.right.left = new TreeNode(6);

        root.left.right.right = new TreeNode(8);

        root.right = new TreeNode(30);
        root.right.right = new TreeNode(40);

        int[] ints = obj.recoverTree(root);
        ArrayUtils.printArray(ints);

    }

    public int[] recoverTree(TreeNode A){

//        Below Lines is for Modified Version of Morris Inorder traversal which is not working now
//        modifiedMorrisInorderTraversal(A);
//        int[] result = new int[2];
//        result[0] = Math.min(first.value,second.value);
//        result[1] = Math.max(first.value,second.value);
//        return result;

        modifiedInorderTraversal(A);
        int[] result = new int[2];
        result[0] = Math.min(first.val,second.val);
        result[1] = Math.max(first.val,second.val);
        return result;

    }

    public void modifiedInorderTraversal(TreeNode node){

        if( node == null) return;
        else{
            modifiedInorderTraversal(node.left);
            if (pre != null) {
                if (pre.val > node.val) {
                    if (first == null) {
                        first = pre;
                    }
                    second = node;
                }
            }
            pre = node;
            modifiedInorderTraversal(node.right);
        }
    }



    // This should work but isn't working.
    public void modifiedMorrisInorderTraversal(TreeNode node) {

        TreeNode current = node;

        while( current != null){
            if(current.left == null){
                System.out.print(current.val +" ");
                if(current.right != null && current.val > current.right.val){
                    if(this.first == null){
                        this.first = current;
                    }
                    this.second = current.right;
                }
                current = current.right;
            }
            else{
                TreeNode predecessor = findPredecessor(current);
                if( predecessor.right == null){
                    predecessor.right = current;
                    if(current.val < current.left.val) {
                        if (this.first == null) {
                            this.first = current.left;
                        }
                        this.second = current;
                    }
                    current = current.left;
                }
                else{
                    predecessor.right = null;
                    System.out.print(current.val +" ");
                    if(current.right != null && current.val > current.right.val){
                        if(this.first == null){
                            this.first = current;
                        }
                        this.second = current.right;
                    }

                    current = current.right;
                }
            }
        }
    }
}
