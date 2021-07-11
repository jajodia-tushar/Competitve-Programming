package com.interviewbit.tree;

/*
Problem Description

You are given a preorder traversal A, of a Binary Search Tree.

Find if it is a valid preorder traversal of a BST.



Problem Constraints
1 <= A[i] <= 106

1 <= |A| <= 105



Input Format
First and only argument is an integer array A denoting the pre-order traversal.



Output Format
Return an integer:

0 : Impossible preorder traversal of a BST
1 : Possible preorder traversal of a BST


Example Input
Input 1:

A = [7, 7, 10, 10, 9, 5, 2, 8]


Example Output
Output 1:

 1
 */

import java.util.Stack;
//SEEAGAIN
public class ValidBSTFromPreorder {

    public static void main(String[] args) {
        ValidBSTFromPreorder obj = new ValidBSTFromPreorder();
        int[] ints = {5, 1, 2, 3, 6, 7, 8, 9};
        int result = obj.solve(ints);
        System.out.println(result);
    }

    public int solve(int[] A) {

        int n = A.length;
        int root = Integer.MIN_VALUE;
        int i = 0;
        Stack<Integer> stack = new Stack<>();

        while (i < n) {
            if (A[i] < root) return 0;
            while (!stack.isEmpty() && stack.peek() < A[i]) {
                root = stack.pop();
            }
            stack.push(A[i]);
            i++;
        }
        return 1;
    }
}


/*
    The Question is Simple but the technique to solve this question is amazing.
    See in Prefix the Pattern of traversal is Root->Left->Right

    If A[i] is root of a subtree then if we find the first greater value on right side of current node.
    Let the index of this node be j then A[i+1…j-1] will represent left subtree and A[j+1….N-1] will
    represent the right subtree.

    Easy Solution is
    Find the first greater value on right side of current node.
    Let the index of this node be j. Return true if following
    conditions hold. Else return false
    All values after the above found greater value are
    greater than current node.
    Recursive calls for the sub arrays A[i+1..j-1] and
    A[j+1..n-1] also return true.
    Time Complexity of the above solution is O(N2)

    In PreOrder of BST. One think You can be certain of is that,
    Once you find a greater number on the right, All the number should be greater than root.
    Where root is the starting point of that Tree.

    Now You start from first. You get the root.
    You put it in the stack ---> Why ?
        --> So that you can pop it when you find a greater number than this number,
        and then you can compare, if all the numbers are greater than this number or  not.

        5,1,2,3,6,7,8,9

        Example, This is a valid PreOrder Traversal of a Tree,
        The Root of the Tree is 5.
        Now you put 5 on Stack.
        And then You traverse to find the greater number than 5 and
        after that greater number all the number should be greater than 5.
        Here in example You find 7 and all the numbers after 7 must be greater than 5.

        You only know this thing.

        But as you traverse after 5 you get 1.
        Now BST property and PreOrder should be recursively valid for this particular
        Sub Tree as well.
        So What you decide is Ok, I am checking for 5 but before that let me check for 1
        if this sub tree is a valid PreOrder traversal.
        So you put 4 in the stack to find a greater number than 1.
        Which You find is 2, Now all the numbers after 2 must be greater than 2.

        Now we apply the same thing for 2 as well.
        We put 2 in the Stack to valid 2 as well.
        This is amazing step.
        If we only valid for 2 we can be sure that 1 is also validate because 2 > 1 so,
        Every number greater than 2 must also be greater than 1 as well.
        So this works like this.



 */