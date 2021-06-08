package com.interviewbit.math;

/*

Hamming distance between two non-negative integers is defined as the number of positions at which the corresponding bits are different.

Given an array A of N non-negative integers, find the sum of hamming distances of all pairs of integers in the array. Return the answer modulo 1000000007.



Problem Constraints
1 <= |A| <= 200000

1 <= A[i] <= 109



Input Format
First and only argument is array A.



Output Format
Return one integer, the answer to the problem.



Example Input
Input 1:

 A = [1]
Input 2:

 A = [2, 4, 6]


Example Output
Output 1:

 0
Output 2:

 8


Example Explanation
Explanation 1:

 No pairs are formed.
Explanation 2:

 We return, f(2, 2) + f(2, 4) + f(2, 6) + f(4, 2) + f(4, 4) + f(4, 6) + f(6, 2) + f(6, 4) + f(6, 6) = 8

 */
public class SumOfPairwiseHammingDistance {

    public static void main(String[] args) {

        SumOfPairwiseHammingDistance obj = new SumOfPairwiseHammingDistance();
        int[] ints = {2, 4, 8};

        int result = obj.hammingDistance(ints);
        System.out.println(result);
    }

    public int hammingDistance(final int[] A) {

        int n = A.length;
        long sum = 0;

        for (int i = 0; i < 31; i++) {
            long count = 0;
            for (int j = 0; j < n; j++) {
                int item = A[j];
                if ((item & (1 << i)) >= 1) {
                    count++;
                }
            }
            sum = (sum + (count * (n - count) * 2)) % 1000000007;
        }

        return (int) sum;
    }


    // Simple Understandable solutions that gives TLE
    public int hammingDistanceX(final int[] A) {

        int n = A.length;
        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int xor = A[i] ^ A[j];
                count += getNumberOfSetBits(xor);
                count %= 1000000007;
            }
        }

        return (int) (count) * 2;
    }

    public int getNumberOfSetBits(int n) {

        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}

/*
    We need the result for all pair.
    So if we do for unique pair then we can multiply with 2.

    The idea is to consider all the bits.
    And for each bit see how many numbers are there to set it true as count
    and n - count bits has unset bit.

    so the distance would be count * (n - count)
    Now all pair so we need to multiply with 2.  f(2,4) and also f(4,2)
    Nothing more

    TL;DR
    number of Smaller character or right * (n - 1) !


 */
