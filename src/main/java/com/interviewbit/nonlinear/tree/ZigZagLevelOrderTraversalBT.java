package com.interviewbit.nonlinear.tree;

import com.interviewbit.nonlinear.util.TreeNode;
import com.interviewbit.utils.ArrayUtils;

import java.util.*;

public class ZigZagLevelOrderTraversalBT {

    public static void main(String[] args) {

        ZigZagLevelOrderTraversalBT obj = new ZigZagLevelOrderTraversalBT();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(30);

        root.left.left = new TreeNode(-2);
        root.left.right = new TreeNode(-1);

        root.left.left.right = new TreeNode(2);
        root.left.left.right.left = new TreeNode(6);

        root.left.right.right = new TreeNode(8);

        root.right = new TreeNode(30);
        root.right.right = new TreeNode(40);

        int[][] ints = obj.zigzagLevelOrder(root);
        ArrayUtils.printArray(ints);
    }

    public int[][] zigzagLevelOrder(TreeNode A) {


        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);

        while(!queue.isEmpty()){

            int size = queue.size();
            ArrayList<Integer> inner = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                inner.add(current.val);
                if(current.left != null)
                    queue.add(current.left);

                if(current.right != null)
                    queue.add(current.right);
            }

            result.add(inner);
        }
        int[][] finalResult = new int[result.size()][];
        for(int i = 0; i < result.size(); i++){
            int innerSize = result.get(i).size();
            finalResult[i] = new int[innerSize];
            int k = innerSize - 1;
            for(int j = 0; j < innerSize; j++){
                if( i % 2 == 0)
                    finalResult[i][j] = result.get(i).get(j);
                else
                    finalResult[i][j] = result.get(i).get(k--);
            }
        }

        return finalResult;
    }
}
