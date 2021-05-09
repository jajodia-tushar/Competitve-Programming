package com.interviewbit.dp;

import java.util.Arrays;

public class InterleavingStrings {

    public int[][][] dp;

    public static void main(String[] args) {

        InterleavingStrings obj = new InterleavingStrings();
        String A = "aabcc";
        String B = "dbbca";
        String C = "aadbbcbcac";
        int result = obj.isInterleave(A, B, C);
        System.out.println(result);
    }

    public int isInterleave(String A, String B, String C) {

        int l1 = A.length();
        int l2 = B.length();
        int l3 = C.length();

        dp = new int[l1 + 1][l2 + 1][l3 + 1];
        for (int[][] x : dp) {
            for (int[] y : x) {
                Arrays.fill(y, -1);
            }
        }

        return isInterleaving(A, B, C, 0, 0, 0);
    }

    public int isInterleaving(String A, String B, String C, int i, int j, int k) {

        if (i == A.length() && j == B.length() && k == C.length()) return dp[i][j][k] = 1;

        if (k >= C.length()) return 0;

        if (dp[i][j][k] != -1) return dp[i][j][k];

        int ans = 0;

        if (i < A.length() && A.charAt(i) == C.charAt(k)) {
            ans |= isInterleaving(A, B, C, i + 1, j, k + 1);
        }

        if (j < B.length() && B.charAt(j) == C.charAt(k)) {
            ans |= dp[i][j][k] = isInterleaving(A, B, C, i, j + 1, k + 1);
        }

        return dp[i][j][k] = ans;


    }
}
