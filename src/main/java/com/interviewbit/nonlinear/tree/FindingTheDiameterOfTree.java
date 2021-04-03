package com.interviewbit.nonlinear.tree;

import com.interviewbit.nonlinear.util.TreeNode;

public class FindingTheDiameterOfTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        FindingTheDiameterOfTree obj = new FindingTheDiameterOfTree();
        System.out.println(obj.findDiameter(root));
        System.out.println(obj.findDiameterOptimized(root).diameter);
    }

    public int findDiameter(TreeNode root){

        if(root == null)
            return 0;

        int left = findHeight(root.left);
        int right = findHeight(root.right);

        int currHeight = left + right + 2;
        int leftHeight = findDiameter(root.left);
        int rightHeight = findDiameter(root.right);

        return Math.max(currHeight,Math.max(leftHeight,rightHeight));
    }

    public DiameterAndHeight findDiameterOptimized(TreeNode node){

        if(node == null)
            return new DiameterAndHeight(0,-1);

        DiameterAndHeight left = findDiameterOptimized(node.left);
        DiameterAndHeight right = findDiameterOptimized(node.right);

        int leftDiameter = left.diameter;
        int leftHeight = left.height;

        int rightDiameter = right.diameter;
        int rightHeight = right.height;
        // Using Same as Above Method Formula
        int myDiameter = Math.max(leftDiameter,Math.max(rightDiameter,leftHeight + rightHeight + 2));
        // Think About this. This is same as finding Height.
        int myHeight = Math.max(leftHeight,rightHeight) + 1;

        return new DiameterAndHeight(myDiameter,myHeight);
    }




    public int findHeight(TreeNode node){
        if( node == null)
            return -1;

        int left = findHeight(node.left);
        int right = findHeight(node.right);

        if(left > right){
            return left + 1;
        }
        else
            return right + 1;
    }



}

class DiameterAndHeight{

    public int diameter;
    public int height;


    public DiameterAndHeight(int diameter, int height){
        this.diameter = diameter;
        this.height = height;
    }
}
