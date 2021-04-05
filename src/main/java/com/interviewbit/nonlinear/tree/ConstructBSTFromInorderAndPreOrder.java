package com.interviewbit.nonlinear.tree;

import com.interviewbit.nonlinear.util.TreeNode;
import com.interviewbit.utils.ArrayUtils;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class ConstructBSTFromInorderAndPreOrder {

    public static void main(String[] args) {

        ConstructBSTFromInorderAndPreOrder obj = new ConstructBSTFromInorderAndPreOrder();
//        int[] preOrder = ArrayUtils.asArrays(11, 14, 21, 20, 18, 28, 1, 10, 30, 26, 25, 8, 2, 4, 19, 27, 12, 6, 9, 23, 29, 17, 15, 31, 5, 16, 3, 24, 22, 13, 7);
//        int[] inOrder = ArrayUtils.asArrays(28, 1, 18, 10, 20, 30, 26, 25, 8, 2, 21, 4, 19, 14, 27, 11, 9, 23, 6, 17, 15, 29, 31, 12, 3, 16, 5, 24, 7, 13, 22);

        int[] preOrder = ArrayUtils.asArrays( 1, 2, 3 );
        int[] inOrder = ArrayUtils.asArrays(2, 1, 3 );
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
