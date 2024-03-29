package com.interviewbit.dp.lcsvariation;

import java.util.Arrays;

public class LongestCommonSubString {

    public static void main(String[] args) {
        LongestCommonSubString obj = new LongestCommonSubString();
        String A = "PRQS";
        String B = "PRAB";

        int result = obj.solveRecursive(A, B);
        System.out.println(result);
    }

    public int solveRecursive(String A, String B) {

        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return recursive(A, B, n, m, dp);
    }

    public int recursive(String A, String B, int n, int m, int[][] dp) {

        if (n == 0 || m == 0) return 0;

        char aChar = A.charAt(n - 1);
        char bChar = B.charAt(m - 1);

        if (dp[n][m] != -1)
            return dp[n][m];

        if (aChar == bChar) {
            dp[n][m] = 1 + recursive(A, B, n - 1, m - 1, dp);
        } else {
            dp[n][m] = Math.max(recursive(A, B, n - 1, m, dp), recursive(A, B, n, m - 1, dp));
        }
        return dp[n][m];
    }

    public int iterative(String A, String B) {

        int result = 0;
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                char aChar = A.charAt(i - 1);
                char bChar = B.charAt(j - 1);

                if (aChar == bChar) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    result = Math.max(result, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return result;
    }
}
