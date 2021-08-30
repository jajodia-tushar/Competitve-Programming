package com.leetcode.junechallenge;

import com.interviewbit.tree.InorderTraversal;
import com.interviewbit.tree.PreOrderTraversal;
import com.interviewbit.utils.ArrayUtils;
import com.interviewbit.utils.TreeNode;

import java.util.ArrayList;

/*
    Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary
    tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

    Example 1:
    Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    Output: [3,9,20,null,null,15,7]

    Example 2:
    Input: preorder = [-1], inorder = [-1]
    Output: [-1]

    Constraints:
    1 <= preorder.length <= 3000
    inorder.length == preorder.length
    -3000 <= preorder[i], inorder[i] <= 3000
    preorder and inorder consist of unique values.
    Each value of inorder also appears in preorder.
    preorder is guaranteed to be the preorder traversal of the tree.
    inorder is guaranteed to be the inorder traversal of the tree.
 */



public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {

        ConstructBinaryTreeFromPreorderAndInorderTraversal obj = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        int[] preOrder = ArrayUtils.asArrays(1, 2, 3);
        int[] inOrder = ArrayUtils.asArrays(2, 1, 3);

        TreeNode root = obj.buildTree(preOrder, inOrder);
        ArrayList<Integer> inOrderList = new ArrayList<>();
        InorderTraversal.traverse(root, inOrderList);
        ArrayList<Integer> preOrderList = new ArrayList<>();
        PreOrderTraversal.traverse(root, preOrderList);

        System.out.println("Pre Order Traversal" + preOrderList);
        System.out.println("Inorder Traversal " + inOrderList);

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return build(preorder, inorder, 0, n, 0, n);
    }


    public TreeNode build(int[] pre, int[] in, int pStart, int pEnd, int iStart, int iEnd) {

        if (pStart >= pEnd || iStart >= iEnd) return null;

        int rootValue = pre[pStart];
        TreeNode root = new TreeNode(rootValue);

        int positionOfRootInInorder = -1;
        for (int i = iStart; i < iEnd; i++) {
            if (rootValue == in[i]) {
                positionOfRootInInorder = i;
                break;
            }
        }

        int numberOfElementOfLeftTree = positionOfRootInInorder - iStart;


        root.left = build(pre, in, pStart + 1, pStart + 1 + numberOfElementOfLeftTree,
                iStart, positionOfRootInInorder);
        root.right = build(pre, in, pStart + 1 + numberOfElementOfLeftTree, pEnd, positionOfRootInInorder + 1, iEnd);
        return root;
    }
}

/*
    You Want to create a Binary Tree.
    You are Given Inorder LWR and PreOrder WLR.
    So see the First Element in the PreOrder is going to be the root.
    And you search for this element in the InOrder list.
    So All the elements previous to this Element in the PreOrder List are in the
    Left sub Tree and All the elements on the Right are On Right Sub Array.
    You can use this information to Build the solutions recursively.
 */