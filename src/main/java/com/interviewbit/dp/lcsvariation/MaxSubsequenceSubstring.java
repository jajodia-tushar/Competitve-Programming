package com.interviewbit.dp.lcsvariation;

public class MaxSubsequenceSubstring {

    public static void main(String[] args) {
        MaxSubsequenceSubstring obj = new MaxSubsequenceSubstring();
        String A = "ABCD";
        String B = "BACDBDCD";
        int result = obj.maxSubsequenceSubstring(A, B);
        System.out.println(result);
    }

    public int maxSubsequenceSubstring(String A, String B) {

        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n + 1][m + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {

                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    //Why did we use dp[i - 1][j] and not dp[i][j - 1]
                    // See dp[i][j] represents the maximum common string that is the subsequence
                    // of string A ending at i and substring of B ending at j.
                    // So if i is not matched with j we will say the maximum ending at i
                    // is what ever was ending till dp[i-1][j] this allows for subsequences.
                    // We can't do this in case of substring.

                    dp[i][j] = dp[i - 1][j];
                }
                // This is the reason we have to do max to find out the maximum till now.
                // Because dp[n][m] won't give maximum.
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
