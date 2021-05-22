package com.interviewbit.tree;

import com.interviewbit.utils.TreeNode;
import com.interviewbit.utils.ArrayUtils;

import java.util.*;
public class CousinsInBinaryTree {

    public static void main(String[] args) {
        CousinsInBinaryTree obj = new CousinsInBinaryTree();
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

        int[] ints = obj.solve(root, 8);
        ArrayUtils.printArray(ints);

    }

    public int[] solve(TreeNode A, int B) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        boolean isReached = false;

        while(!queue.isEmpty()){
            int size = queue.size();
            if(!isReached){
                for(int i = 1; i <= size; i++){
                    TreeNode current = queue.poll();
                    if((current.left != null && current.left.val == B) ||
                            (current.right != null && current.right.val == B)){
                        isReached = true;
                    }
                    else{
                        if(current.left != null) queue.add(current.left);
                        if(current.right != null) queue.add(current.right);
                    }
                }
            }
            else{
                break;
            }
        }
        return queue.stream().mapToInt(x -> x.val).toArray();
    }
}
