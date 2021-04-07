package com.interviewbit.nonlinear.tree;

import com.interviewbit.nonlinear.util.TreeNode;
import com.interviewbit.utils.ArrayUtils;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class ConstructBSTFromInorderAndPreOrder {

    public static void main(String[] args) {

        ConstructBSTFromInorderAndPreOrder obj = new ConstructBSTFromInorderAndPreOrder();
        int[] preOrder = ArrayUtils.asArrays(1,2,3);
        int[] inOrder = ArrayUtils.asArrays(2,1,3);

        TreeNode root = obj.constructBST(inOrder, preOrder, 0, inOrder.length, 0, preOrder.length);
        ArrayList<Integer> inOrderList = new ArrayList<>();
        InorderTraversal.traverse(root,inOrderList);
        ArrayList<Integer> preOrderList = new ArrayList<>();
        PreOrderTraversal.traverse(root,preOrderList);

        System.out.println("Pre Order Traversal"+preOrderList);
        System.out.println("Inorder Traversal "+inOrderList);


    }

    public TreeNode constructBST(int[] inOrder, int[] preOrder, int iStart, int iEnd, int pStart, int pEnd){

        if( iStart >= iEnd || pStart >= pEnd) return null;
        int rootValue = preOrder[pStart];
        TreeNode root = new TreeNode(rootValue);
        int leftTreeEndIndex = -1;
        for(int i = iStart; i < iEnd; i++){
            if(rootValue == inOrder[i]){
                leftTreeEndIndex = i;
                break;
            }
        }

        int numberOfElements = leftTreeEndIndex - iStart;
        root.left = constructBST(inOrder,preOrder,iStart,leftTreeEndIndex,pStart + 1,pStart + 1 + numberOfElements);
        root.right = constructBST(inOrder,preOrder,leftTreeEndIndex + 1, iEnd,pStart+numberOfElements + 1,pEnd);

        return root;
    }
}
