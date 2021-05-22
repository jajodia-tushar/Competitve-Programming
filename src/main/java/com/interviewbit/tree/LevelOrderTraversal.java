package com.interviewbit.tree;

import com.interviewbit.utils.TreeNode;
import com.interviewbit.utils.ArrayUtils;
import java.util.*;

public class LevelOrderTraversal {

    public static void main(String[] args) {

        LevelOrderTraversal obj = new LevelOrderTraversal();

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

        int[][] ints = obj.levelOrder(root);
        ArrayUtils.printArray(ints);
    }


    public int[][] levelOrder(TreeNode A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);

        while(!queue.isEmpty()){
            int numberOfNodes = queue.size();
            ArrayList<Integer> innerList = new ArrayList<>();
            for(int i = 0; i < numberOfNodes; i++){
                TreeNode curr = queue.poll();
                if(curr.left != null){
                    queue.add(curr.left);
                }

                if(curr.right != null){
                    queue.add(curr.right);
                }
                innerList.add(curr.val);
            }
            result.add(innerList);
        }

        int n = result.size();
        int[][] finalResult = new int[n][];

        int i = 0;
        for(ArrayList<Integer> inner : result){
            finalResult[i++] = inner.stream().mapToInt(x -> x).toArray();
        }

        return finalResult;
    }
}
