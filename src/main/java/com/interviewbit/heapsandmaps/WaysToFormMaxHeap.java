package com.interviewbit.heapsandmaps;


/*
Problem Description

Max Heap is a special kind of complete binary tree in which for every node the value present in that node is greater than the value present in it’s children nodes.

Find the number of distinct Max Heap can be made from A distinct integers.

In short, you have to ensure the following properties for the max heap :

Heap has to be a complete binary tree ( A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.)
Every node is greater than all its children.
NOTE: If you want to know more about Heaps, please visit this link. Return your answer modulo 109 + 7.



Problem Constraints
1 <= A <= 100



Input Format
First and only argument is an inetegr A.



Output Format
Return an integer denoting the number of distinct Max Heap.



Example Input
Input 1:

 A = 4
Input 2:

 A = 10


Example Output
Output 1:

 3
Output 2:

 3360


Example Explanation
Explanation 1:

 Let us take 1, 2, 3, 4 as our 4 distinct integers
 Following are the 3 possible max heaps from these 4 numbers :
      4           4                     4
    /  \         / \                   / \
   3    2   ,   2   3      and        3   1
  /            /                     /

 1            1                     2
Explanation 2:

 Number of distinct heaps possible with 10 distinct integers = 3360.
 */

public class WaysToFormMaxHeap {

    public static int MOD = 1000000007;

    public static void main(String[] args) {
        WaysToFormMaxHeap obj = new WaysToFormMaxHeap();
        System.out.println(obj.solve(20));
    }


    public long[][] calculateNCR(int N, int R) {
        long[][] ncr = new long[N + 1][R + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= R; j++) {
                if (i == 0) {
                    ncr[i][j] = 0;
                } else if (i == j || j == 0) {
                    ncr[i][j] = 1;
                } else if (j > i) {
                    ncr[i][j] = 0;
                } else {
                    ncr[i][j] = ncr[i - 1][j - 1] % MOD + ncr[i - 1][j] % MOD;
                }
            }
        }

        return ncr;
    }

    public int calculate(int A, long[][] ncr) {

        if (A <= 1)
            return 1;
        int numberOfNodesInLeft = getNumberOfNodesInLeft(A);
        return (int)
                ((((((ncr[A - 1][numberOfNodesInLeft] % MOD)
                        * (calculate(numberOfNodesInLeft, ncr) % MOD)) % MOD))
                        * (calculate(A - numberOfNodesInLeft - 1, ncr) % MOD)) % MOD);
    }

    public int solve(int A) {

        if (A <= 1)
            return 1;
        long[][] ncr = calculateNCR(A, A);
        return calculate(A, ncr);
    }

    public int getNumberOfNodesInLeft(int A) {
        int h = getHeight(A);
        int maximumNumberOfNodesInHthLevel = 1 << h;
        int numberOfNodesInLastLevel = A - (maximumNumberOfNodesInHthLevel - 1);

        if (numberOfNodesInLastLevel >= (maximumNumberOfNodesInHthLevel / 2))
            return maximumNumberOfNodesInHthLevel - 1;
        else
            return (maximumNumberOfNodesInHthLevel - 1)
                    - ((maximumNumberOfNodesInHthLevel / 2) - numberOfNodesInLastLevel);
    }

    // This one is Simple and Intuitive.
    public int getLeftNodesCount(int totalNodes) {
        int h = getHeight(totalNodes);
        int completelyFilled = (int) Math.pow(2, h) - 1;
        int completelyFilledLeft = (completelyFilled) / 2;

        int nodesInLastLevel = totalNodes - completelyFilled;
        int maxNodesInLastLevel = (int) Math.pow(2, h);

        if ((maxNodesInLastLevel / 2) > nodesInLastLevel) {
            return completelyFilledLeft + nodesInLastLevel;
        } else {
            return completelyFilledLeft + (maxNodesInLastLevel / 2);
        }
    }

    public int getHeight(int A) {
        return (int) (Math.log(A) / Math.log(2));
    }

}
/*
    The Structures of the heap won't change.
    It will remain the complete Binary Tree.

    Now You just have to do something in recursive fashion.
    Get the number of Nodes in left Sub Tree
    and Find n-1Cr ( where n is the total number of nodes in tree and r is in left sub tree).
        You are actually trying to find the number of ways to form left sub tree.
         l




 */
