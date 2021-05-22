package com.interviewbit.tree;

import com.interviewbit.utils.BTreePrinter;
import com.interviewbit.utils.TreeNode;
import com.interviewbit.utils.ArrayUtils;

public class InorderTraversalOfCartesianTree {

    public static void main(String[] args) {

        InorderTraversalOfCartesianTree obj = new InorderTraversalOfCartesianTree();
        int[] ints = ArrayUtils.asArrays(1, 2, 3, 5, 6, 7, 9, 3, 4, 7);
        TreeNode root = obj.buildTree(ints);
        BTreePrinter.printNode(root);
    }

    public TreeNode buildTree(int[] A) {
        return construct(A,0, A.length);
    }


    public TreeNode construct(int[] A, int start, int end){

        if( end <= start) return null;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i = start; i < end; i++){
            if( A[i] > max){
                max = A[i];
                maxIndex = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = construct(A,start, maxIndex);
        node.right = construct(A, maxIndex + 1, end);
        return node;
    }

}
