package com.interviewbit.dp.lcsvariation;

import java.util.Arrays;

public class MinimumInsertAndDeleteToMakePalindrome {

    public static void main(String[] args) {

        MinimumInsertAndDeleteToMakePalindrome obj = new MinimumInsertAndDeleteToMakePalindrome();
        String A = "geeks";
        int result = obj.findMinInsertionsAndDeletionLCS(A);
        System.out.println(result);

    }

    public int findMinInsertionsAndDeletionLCS(String A) {

        String B = new StringBuilder(A).reverse().toString();
        LongestCommonSubSequence obj = new LongestCommonSubSequence();
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] a : dp) Arrays.fill(a, -1);
        obj.recursive(A, B, n, m, dp);
        int lcs = dp[n][m];

        return n - lcs;
    }
}
