package com.interviewbit.dp.lcsvariation;


import java.util.Arrays;

/*
    Given two strings str1 and str2,
    the task is to find the length of
    the shortest string that has both str1 and str2 as subsequences.
 */
public class ShortestCommonSuperSequence {

    public static void main(String[] args) {

        ShortestCommonSuperSequence obj = new ShortestCommonSuperSequence();
        String A = "abcdaf";;
        String B = "acbcf";;
        int result = obj.shortestSuperSequence(A, B);
        System.out.println(result);
    }

    public int shortestSuperSequence(String A, String B){
        LongestCommonSubSequence obj = new LongestCommonSubSequence();
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] a : dp) Arrays.fill(a, -1);
        obj.recursive(A, B, n, m, dp);
        return n + m - dp[n][m];
    }
}
