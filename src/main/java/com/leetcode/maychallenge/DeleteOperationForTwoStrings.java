package com.leetcode.maychallenge;

import java.util.Arrays;

public class DeleteOperationForTwoStrings {

    int[][] dp;

    public static void main(String[] args) {
        DeleteOperationForTwoStrings obj = new DeleteOperationForTwoStrings();
        int result = obj.minDistance("leetcode", "etco");
        System.out.println(result);
    }

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();
        dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int lcs = getLCS(word1, word2, m - 1, n - 1);
        int l1 = m - lcs;
        int l2 = n - lcs;
        return l1 + l2;
    }


    public int getLCS(String word1, String word2, int i, int j) {

        if (i == -1 || j == -1) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = 1 + getLCS(word1, word2, i - 1, j - 1);
        } else {
            dp[i][j] = Math.max(getLCS(word1, word2, i, j - 1), getLCS(word1, word2, i - 1, j));
        }

        return dp[i][j];

    }
}
