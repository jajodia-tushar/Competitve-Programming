package com.interviewbit.math;


import com.interviewbit.utils.ArrayUtils;

import java.util.Arrays;

/*
Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

NOTE A solution will always exist. read Goldbach’s conjecture

Example:


Input : 4
Output: 2 + 2 = 4

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b,
and [c,d] is another solution with c <= d, then

[a, b] < [c, d]

If a < c OR a==c AND b < d.
 */
public class PrimeSum {

    public static void main(String[] args) {
        PrimeSum obj = new PrimeSum();
        int[] result = obj.primesum(608);
        ArrayUtils.printArray(result);
    }

    public int[] primesum(int A) {

        boolean[] dp = new boolean[A + 1];
        Arrays.fill(dp, true);

        dp[0] = dp[1] = false;

        for (int i = 2; i * i <= A; i++) {
            if (dp[i]) {
                for (int j = i * i; j <= A; j += i) {
                    dp[j] = false;
                }
            }
        }

        for (int i = 2; i <= A; i++) {
            if (dp[i] && dp[A - i]) {
                return new int[]{i, A - i};
            }
        }

        return null;
    }
}

/*
    Quite Straight Forward.
    No need to explain.
    Just find all the prime less than given number and start from 2 till up return where
    you find i and number - i;


 */
