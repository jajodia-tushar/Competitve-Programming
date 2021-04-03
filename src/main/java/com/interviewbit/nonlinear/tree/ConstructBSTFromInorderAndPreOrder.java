package com.interviewbit.nonlinear.tree;

import com.interviewbit.nonlinear.util.TreeNode;
import com.interviewbit.utils.ArrayUtils;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class ConstructBSTFromInorderAndPreOrder {

    public static void main(String[] args) {

        ConstructBSTFromInorderAndPreOrder obj = new ConstructBSTFromInorderAndPreOrder();
        int[] inOrder = ArrayUtils.asArrays(5, 6, 7, 8, 9, 10, 11, 12, 13, 19, 25);
        int[] preOrder = ArrayUtils.asArrays(10, 8, 6, 5, 7, 9, 12, 11, 19, 13, 25);

        TreeNode root = obj.constructBST(inOrder, preOrder, 0, inOrder.length, 0, preOrder.length);
        ArrayList<Integer> inOrderList = new ArrayList<>();
        InorderTraversal.traverse(root,inOrderList);
        System.out.println(inOrderList);

        ArrayList<Integer> preOrderList = new ArrayList<>();
        PreOrderTraversal.traverse(root,preOrderList);
        System.out.println(preOrderList);
    }


    public TreeNode constructBST(int[] inOrder, int[] preOrder, int iStart, int iEnd, int pStart, int pEnd){

        TreeNode node = new TreeNode(preOrder[pStart]);
        if((iEnd - iStart) <= 1 || (pEnd - pStart) <= 1)
            return node;

        int leftSubTreeIEnd = -1;
        for(int i = iStart; i < iEnd; i++){
            if( inOrder[i] == preOrder[pStart]){
                leftSubTreeIEnd = i;
                break;
            }
        }

//        int leftSubTreePEnd = -1;
//        for(int i = pStart; i < pEnd; i++) {
//            if (preOrder[i] == inOrder[leftSubTreeIEnd - 1]) {
//                leftSubTreePEnd = i + 1;
//                break;
//            }
//        }
//      This Above Iteration Can Be Removed calculating the Number of Items in the Left and Right Sub Arrays as follows.
        int numElements = leftSubTreeIEnd - iStart;

        node.left = constructBST(inOrder,preOrder,iStart,leftSubTreeIEnd,pStart + 1,pStart + numElements);
        node.right = constructBST(inOrder,preOrder,leftSubTreeIEnd + 1,iEnd,pStart + numElements + 1,pEnd);

        return node;

    }


}
