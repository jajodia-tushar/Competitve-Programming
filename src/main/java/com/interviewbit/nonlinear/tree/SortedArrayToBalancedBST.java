package com.interviewbit.nonlinear.tree;

import com.interviewbit.nonlinear.util.BTreePrinter;
import com.interviewbit.nonlinear.util.TreeNode;
import com.interviewbit.utils.ArrayUtils;

public class SortedArrayToBalancedBST {

    public static void main(String[] args) {

        SortedArrayToBalancedBST obj = new SortedArrayToBalancedBST();

        int[] ints = ArrayUtils.asArrays(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        TreeNode result = obj.sortedArrayToBST(ints);
        BTreePrinter.printNode(result);
    }

    public TreeNode sortedArrayToBST(final int[] A) {

        return construct(A,0,A.length);
    }

    public TreeNode construct(int[] A, int start, int end){

        if( start >= end) return null;

        int mid = (start + end) / 2;

        TreeNode node = new TreeNode(A[mid]);
        node.left = construct(A,start,mid);
        node.right = construct(A,mid+1,end);
        return node;
    }
}
