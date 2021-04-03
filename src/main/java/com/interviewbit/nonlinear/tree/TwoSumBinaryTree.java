package com.interviewbit.nonlinear.tree;

import com.interviewbit.nonlinear.util.TreeNode;

import java.util.ArrayList;

public class TwoSumBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(25);

        root.left = new TreeNode(20);
        root.right = new TreeNode(36);

        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(22);

        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(12);

        root.right.left = new TreeNode(30);
        root.right.left.left = new TreeNode(28);

        root.right.right = new TreeNode(40);
        root.right.right.left = new TreeNode(38);
        root.right.right.right = new TreeNode(48);

        TwoSumBinaryTree obj = new TwoSumBinaryTree();
        System.out.println(obj.inOrderRevInOrder(root,500));
    }

    public int inOrderRevInOrder(TreeNode A, int B){
        ArrayList<TreeNode> inOrderList = new ArrayList<>();
        ArrayList<TreeNode> reverseInOrderList = new ArrayList<>();

        TreeNode left = A;
        while(left.left != null){
            inOrderList.add(left);
            left = left.left;
        }

        TreeNode right = A;
        while(right.right != null){
            reverseInOrderList.add(right);
            right = right.right;
        }


        while(true){

            int sum = left.value + right.value;

            if( (left == right) || left.value > right.value )
                return 0;

            if( sum == B){
                System.out.println(left.value+" "+right.value);
                return 1;
            }
            else if( sum < B){

                if(left.right != null){

                    TreeNode lRight = left.right;
                    while(lRight.left != null){
                        inOrderList.add(lRight);
                        lRight = lRight.left;
                    }
                    left = lRight;
                }
                else{
                    left = inOrderList.get(inOrderList.size() - 1);
                    inOrderList.remove(inOrderList.size() - 1);
                }
            }
            else{


                if(right.left != null){

                    TreeNode rLeft = right.left;
                    while(rLeft.right != null){
                        reverseInOrderList.add(rLeft);
                        rLeft = rLeft.right;
                    }
                    right = rLeft;
                }
                else{
                    right = reverseInOrderList.get(reverseInOrderList.size() - 1);
                    reverseInOrderList.remove(reverseInOrderList.size() - 1);
                }
            }
        }
    }
}
