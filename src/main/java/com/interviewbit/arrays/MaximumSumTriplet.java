package com.interviewbit.arrays;


import java.util.TreeSet;

/*
Problem Description

Given an array A containing N integers.

You need to find the maximum sum of triplet ( Ai + Aj + Ak ) such that 0 <= i < j < k < N and Ai < Aj < Ak.

If no such triplet exist return 0.



Problem Constraints
3 <= N <= 105.

1 <= A[i] <= 108.



Input Format
First argument is an integer array A.



Output Format
Return a single integer denoting the maximum sum of triplet as described in the question.



Example Input
Input 1:

 A = [2, 5, 3, 1, 4, 9]
Input 2:

 A = [1, 2, 3]


Example Output
Output 1:

 16
Output 2:

 6


Example Explanation
Explanation 1:

 All possible triplets are:-
    2 3 4 => sum = 9
    2 5 9 => sum = 16
    2 3 9 => sum = 14
    3 4 9 => sum = 16
    1 4 9 => sum = 14
  Maximum sum = 16
Explanation 2:

 All possible triplets are:-
    1 2 3 => sum = 6
 Maximum sum = 6
 */
public class MaximumSumTriplet {

    public static void main(String[] args) {

    }

    public int solve(int[] A) {

        int n = A.length;
        int[] suffix = new int[n];

        suffix[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], A[i]);
        }

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(Integer.MIN_VALUE);
        treeSet.add(A[0]);
        int ans = Integer.MIN_VALUE;

        for (int i = 1; i < n - 1; i++) {
            int high = suffix[i + 1];

            if (high > A[i]) {
                int lower = treeSet.lower(A[i]);
                ans = Math.max(ans, (lower + A[i] + high));
            }
            treeSet.add(A[i]);
        }

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}

/*

    There is nothing fancy in this question now.
    Consider every element as middle element now you just have to find max smaller number on left and
    max greater number on right.
    for right you can maintain a suffix Array.
    for left you need greatest lesser number than your current number.
    so you can do binary search on the left array.
    But it was not working
    So Use TreeSet lower function what will give you the lower value than the supplied value.


 */
