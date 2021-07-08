package com.interviewbit.hashing;

import com.interviewbit.twopointer.PairWithGivenDifference;

import java.util.HashSet;

/*
Problem Description

Given an 1D integer array A containing N distinct integers.

Find the number of unique pairs of integers in the array whose XOR is equal to B.

NOTE:

Pair (a, b) and (b, a) is considered to be same and should be counted once.


Problem Constraints
1 <= N <= 105

1 <= A[i], B <= 107



Input Format
First argument is an 1D integer array A.

Second argument is an integer B.



Output Format
Return a single integer denoting the number of unique pairs of integers in the array A whose XOR is equal to B.



Example Input
Input 1:

 A = [5, 4, 10, 15, 7, 6]
 B = 5
Input 2:

 A = [3, 6, 8, 10, 15, 50]
 B = 5


Example Output
Output 1:

 1
Output 2:

 2


Example Explanation
Explanation 1:

 (10 ^ 15) = 5
Explanation 2:

 (3 ^ 6) = 5 and (10 ^ 15) = 5
 */
public class PairsWithGivenXor {

    public static void main(String[] args) {
        PairsWithGivenXor obj = new PairsWithGivenXor();
        int[] ints = {5, 4, 10, 15, 7, 6};
        int result = obj.solve(ints, 5);
        System.out.println(result);
    }

    public int solve(int[] A, int B) {

        HashSet<Integer> sets = new HashSet<>();
        int n = A.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (sets.contains(A[i] ^ B)) count++;
            sets.add(A[i]);
        }
        return count;

    }
}

/*
    The Property of XOR Is
    A ^ B = C
    then B ^ C = A
    and  A ^ C = B

    So we can use HashMap to keep track of the Xor and a Count variable to keep the number of occurrence.

 */