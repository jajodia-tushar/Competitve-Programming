package com.interviewbit.dp.lcsvariation;


/*
    Given a string A, find length of the longest repeating sub-sequence
    such that the two subsequence don’t have same string character at same position,
    i.e., any i’th character in the two subsequences shouldn’t have the same index in the original string.
    NOTE: Sub-sequence length should be greater than or equal to 2.

 */
public class LargestRepeatingSubSequence {

    public static void main(String[] args) {
        LargestRepeatingSubSequence obj = new LargestRepeatingSubSequence();
        String A = "abab";
        int result = obj.anyTwo(A);
        System.out.println(result);
    }

    public int anyTwo(String A) {

        String B = A;
        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {

                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                if (A.charAt(i - 1) == B.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[n][m];


    }

}
