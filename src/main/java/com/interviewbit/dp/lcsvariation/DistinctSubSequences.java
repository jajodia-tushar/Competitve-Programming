package com.interviewbit.dp.lcsvariation;


/*
Given two sequences A, B, count number of unique ways in sequence A, to form a subsequence that is identical to the sequence B.
Subsequence : A subsequence of a string is a new string which is formed from the original
string by deleting some (can be none) of the characters without disturbing
the relative positions of the remaining characters. (ie, “ACE” is a subsequence of “ABCDE” while “AEC” is not).

Or

Given two strings, find the number of times the second string occurs in the first string, whether continuous or discontinuous.

 */

public class DistinctSubSequences {

    public int numDistinct(String A, String B) {

        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {

                if (i == 0 || j == 0) {
                    dp[i][j] = (j == 0) ? 1 : 0;
                } else if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[n][m];
    }
}
