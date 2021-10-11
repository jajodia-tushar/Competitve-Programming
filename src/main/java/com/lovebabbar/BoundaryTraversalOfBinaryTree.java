package com.lovebabbar;

import com.interviewbit.utils.TreeNode;

import java.util.*;

/*
    Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order:
    Left boundary nodes: defined as the path from the root to the left-most node ie- the leaf
    node you could reach when you always travel preferring the left subtree over the right subtree.
    Leaf nodes: All the leaf nodes except for the ones that are part of left or right boundary.
    Reverse right boundary nodes: defined as the path from the right-most node to the root.
    The right-most node is the leaf node you could reach when you always travel preferring
    the right subtree over the left subtree. Exclude the root from this as it was already
    included in the traversal of left boundary nodes.

 */
public class BoundaryTraversalOfBinaryTree {

    public static void main(String[] args) {

    }

    List<Integer> printBoundary(TreeNode node)
    {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(node.val);
        leftTree(result,node.left);
        leafNode(result,node);
        rightTree(result,node.right);
        return result;
    }

    public void leafNode(ArrayList<Integer> result,TreeNode node){

        if( node == null) return;
        if( node.left == null && node.right == null){
            result.add(node.val);
            return;
        }
        leafNode(result,node.left);
        leafNode(result,node.right);
    }


    public void leftTree(ArrayList<Integer> result, TreeNode node){
        if(node == null) return;
        if( node.left == null && node.right == null) return;
        if( node.left != null){
            result.add(node.val);
            leftTree(result,node.left);
        }
        else{
            result.add(node.val);
            leftTree(result,node.right);
        }
    }

    public void rightTree(ArrayList<Integer> result, TreeNode node){
        if(node == null) return;
        if( node.left == null && node.right == null) return;
        if( node.right != null){
            rightTree(result,node.right);
            result.add(node.val);
        }
        else{
            rightTree(result,node.left);
            result.add(node.val);
        }
    }
}

/*
    The Idea is simple.
    See every level will have the boundary nodes.
    YOu have to approach this question in three parts.
    Left Leaf and Right.

    The Left Tree boundary node printing is similar to the one in the right tree.
    See at the current level the left node will be the boundary node.
    and same is the case with the next level.
    But if there is no left sub tree in the current level
    then there is right subtree then it will be the boundary node
    for the next level.
    and we can follow the same approach recursively.

    Similar is the thing for rightBoundary Node Printing as well
    just the value should be added in post order.

        20
       /  \
      10   30
        \  / \
        40 5 50
        /\
       80 90

 */