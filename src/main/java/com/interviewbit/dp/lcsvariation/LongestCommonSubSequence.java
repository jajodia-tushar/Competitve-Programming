package com.interviewbit.dp.lcsvariation;

public class LongestCommonSubSequence {

    public static void main(String[] args) {

        LongestCommonSubSequence obj = new LongestCommonSubSequence();
        String A = "Anshumian";
        String B = "Antihuman";

        int result = obj.solveRecursive(A, B);
        System.out.println(result);

    }

    public int solveIterative(String A, String B) {

        int n = A.length();
        int m = B.length();
        int[][] dp = new int[m + 1][n + 1];


        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                char mChar = B.charAt(i - 1);
                char nChar = A.charAt(j - 1);

                if (mChar == nChar) {

                    dp[i][j] = 1 + dp[i - 1][j - 1];

                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }


        return dp[m][n];
    }

    public int solveRecursive(String A, String B) {

        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }

        return recursive(A, B, n, m, dp);
    }

    public int recursive(String A, String B, int i, int j, int[][] dp) {

        if (i == 0 || j == 0)
            return 0;

        if (dp[i][j] == -1) {
            if (A.charAt(i - 1) == B.charAt(j - 1)) {
                dp[i][j] = 1 + recursive(A, B, i - 1, j - 1, dp);
            } else {
                dp[i][j] = Math.max(recursive(A, B, i, j - 1, dp)
                        , recursive(A, B, i - 1, j, dp));
            }
        }

        return dp[i][j];
    }
}
