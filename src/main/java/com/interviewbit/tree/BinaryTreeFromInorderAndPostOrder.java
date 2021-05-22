package com.interviewbit.tree;

import com.interviewbit.utils.TreeNode;
import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;

public class BinaryTreeFromInorderAndPostOrder {

    public static void main(String[] args) {

        BinaryTreeFromInorderAndPostOrder obj = new BinaryTreeFromInorderAndPostOrder();
        int[] preOrder = ArrayUtils.asArrays(2,1,3);
        int[] inOrder = ArrayUtils.asArrays(2,1,3);

        TreeNode root = obj.construct(inOrder, preOrder, 0, inOrder.length, 0, preOrder.length);
        ArrayList<Integer> inOrderList = new ArrayList<>();
        InorderTraversal.traverse(root,inOrderList);
        ArrayList<Integer> preOrderList = new ArrayList<>();
        PreOrderTraversal.traverse(root,preOrderList);

        System.out.println("Pre Order Traversal"+preOrderList);
        System.out.println("Inorder Traversal "+inOrderList);


    }

    public TreeNode construct(int[] inOrder, int[] postOrder, int iStart, int iEnd, int pStart, int pEnd){

        if( iStart >= iEnd || pStart >= pEnd || pEnd == 0){
            return null;
        }

        int rootValue = postOrder[pEnd - 1];
        TreeNode node = new TreeNode(rootValue);

        int leftTreeEnd = -1;
        for(int i = iStart; i < iEnd ; i++){
            if( inOrder[i] == rootValue){
                leftTreeEnd = i;
                break;
            }
        }

        int numOfElementsInLeft = leftTreeEnd - iStart;

        node.left = construct(inOrder,postOrder,iStart,leftTreeEnd,pStart, pStart + numOfElementsInLeft);
        node.right = construct(inOrder,postOrder, leftTreeEnd + 1,iEnd,pStart + numOfElementsInLeft, pEnd - 1);
        return node;
    }
}
