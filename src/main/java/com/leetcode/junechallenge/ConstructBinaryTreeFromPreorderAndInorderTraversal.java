package com.leetcode.junechallenge;

import com.interviewbit.tree.InorderTraversal;
import com.interviewbit.tree.PreOrderTraversal;
import com.interviewbit.utils.ArrayUtils;
import com.interviewbit.utils.TreeNode;

import java.util.ArrayList;

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
