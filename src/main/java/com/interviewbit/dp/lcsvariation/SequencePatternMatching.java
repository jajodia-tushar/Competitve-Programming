package com.interviewbit.dp.lcsvariation;


import java.util.Arrays;

/*
Is A a SubSequence  of B.
 */
public class SequencePatternMatching {

    public static void main(String[] args) {
        SequencePatternMatching obj = new SequencePatternMatching();
        String A = "axyd";
        String B = "adxcpy";
        boolean result = obj.isSubSequence(A, B);
        System.out.println(result);
    }

    public boolean isSubSequence(String A, String B){

        LongestCommonSubSequence obj = new LongestCommonSubSequence();
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] a : dp) Arrays.fill(a, -1);
        obj.recursive(A, B, n, m, dp);
        return n == dp[n][m];
    }


}
