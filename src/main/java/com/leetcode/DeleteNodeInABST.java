package com.leetcode;

import com.interviewbit.utils.TreeNode;

/*
    Given a root node reference of a BST and a key,
    delete the node with the given key in the BST.
    Return the root node reference (possibly updated) of the BST.

    Basically, the deletion can be divided into two stages:

    Search for a node to remove.
    If the node is found, delete the node.
    Follow up: Can you solve it with time complexity O(height of tree)?



    Example 1:


    Input: root = [5,3,6,2,4,null,7], key = 3
    Output: [5,4,6,2,null,null,7]
    Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
    One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
    Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

    Example 2:

    Input: root = [5,3,6,2,4,null,7], key = 0
    Output: [5,3,6,2,4,null,7]
    Explanation: The tree does not contain a node with value = 0.
    Example 3:

    Input: root = [], key = 0
    Output: []
 */
public class DeleteNodeInABST {

    public static void main(String[] args) {

    }

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) return null;

        // System.out.println("Delete " + key + " ---> " + root.val);

        TreeNode leftSubTree = deleteNode(root.left, key);
        TreeNode rightSubTree = deleteNode(root.right, key);

        if (root.val == key) {
            if (leftSubTree == null && rightSubTree == null) return null;
            if (leftSubTree == null) return rightSubTree;
            if (rightSubTree == null) return leftSubTree;

            TreeNode right = root.right;
            while (right.left != null) right = right.left;
            right.right = deleteNode(root.right, right.val);
            right.left = root.left;
            return right;
        }

        root.left = leftSubTree;
        root.right = rightSubTree;

        return root;
    }
}

/*
    If the node that you want to delete is leaf node.  --> No Issues Delete it.
    If the node only has left child replace the current node with left child.
    If the node only has right child replace the current node with right child.

    If the node has both the child. Then get the inOrder successor for the current node.
    Now place this node in current position and delete the successor.
    this can be done using the predecessor as well.

    Look the code you will get it.



 */