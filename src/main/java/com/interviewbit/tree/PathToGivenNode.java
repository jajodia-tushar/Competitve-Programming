package com.interviewbit.tree;

import com.interviewbit.utils.TreeNode;
import com.interviewbit.utils.ArrayUtils;

import java.util.Stack;

public class PathToGivenNode {
    public static void main(String[] args) {

        PathToGivenNode obj = new PathToGivenNode();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);

        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);

        int[] ints = obj.solve(root, 15);
        ArrayUtils.printArray(ints);
    }

    public int[] solve(TreeNode A, int B) {

        Stack<Integer> result = new Stack<>();
        inOrder(A,result,B);

        int[] finalResult = new int[result.size()];

        int i = 0;
        while( !result.isEmpty()){
            finalResult[i++] = result.pop();
        }

        return finalResult;

    }


    public Stack<Integer> inOrder(TreeNode A, Stack<Integer> result, int B){


        if( A == null) return null;

        if(inOrder(A.left,result,B) != null){
            result.add(A.val);
            return result;
        }

        if(A.val == B){
            result.add(A.val);
            return result;
        }

        if(inOrder(A.right,result,B) != null){
            result.add(A.val);
            return result;
        }

        return null;
    }



}
