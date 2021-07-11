package com.interviewbit.tree;

import com.interviewbit.utils.TreeNode;
import com.interviewbit.utils.ArrayUtils;

import static com.interviewbit.tree.InorderTraversal.findPredecessor;

/*
Two elements of a binary search tree (BST) are swapped by mistake.

Tell us the 2 values swapping which the tree will be restored.

Note:

A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

Example :


Input :
         1
        / \
       2   3

Output :
       [1, 2]

Explanation : Swapping 1 and 2 will change the BST to be
         2
        / \
       1   3
which is a valid BST
 */
//SEEAGAIN
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

//        TreeNode.inOrderPrint(root);


        int[] ints = obj.recoverTree(root);
        ArrayUtils.printArray(ints);

    }

    public int[] recoverTree(TreeNode A) {
        traverse(A);
        int[] result = new int[2];
        result[0] = Math.min(first.val, second.val);
        result[1] = Math.max(first.val, second.val);
        return result;
    }

    public TreeNode findPredecessor(TreeNode node) {

        TreeNode predecessor = node.left;
        while (predecessor.right != null && predecessor.right != node) {
            predecessor = predecessor.right;
        }
        return predecessor;
    }

    public void traverse(TreeNode node) {

        while (node != null) {
            if (node.left != null) {
                TreeNode predecessor = findPredecessor(node);
                if (predecessor.right == node) {
                    if (pre != null) {
                        if (pre.val > node.val) {
                            if (first == null)
                                first = pre;
                            second = node;
                        }
                    } else {
                        pre = node;
                    }
                    predecessor.right = null;
                    pre = node;
                    node = node.right;
                } else {
                    predecessor.right = node;
                    node = node.left;
                }
            } else {
                if (pre != null) {
                    if (pre.val > node.val) {
                        if (first == null)
                            first = pre;
                        second = node;
                    }
                }
                pre = node;
                node = node.right;
            }
        }
    }

    // This Works but it is still using stack in recursion
    public void modifiedInorderTraversal(TreeNode node) {

        if (node == null) return;
        else {
            modifiedInorderTraversal(node.left);
            if (pre != null) {
                if (pre.val > node.val) {
                    if (first == null) {
                        first = pre;
                    }
                    second = node;   // -------> Note this Line it is Amazing.
                    //  -------> It is not same as assigning second in else part.
                    //  -------> If the swapped Nodes are adjacent then else part will fail.

                }
            }
            pre = node;
            modifiedInorderTraversal(node.right);
        }
    }
}

/*
    Look Copy For Clarification
 */