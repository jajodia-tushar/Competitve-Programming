package com.interviewbit.dp;

import com.interviewbit.utils.ArrayUtils;

/*
    Implement wildcard pattern matching with support for ‘?’ and ‘*’ for strings A and B.
    ’?’ : Matches any single character.
    ‘*’ : Matches any sequence of characters (including the empty sequence).
    The matching should cover the entire input string (not partial).
 */
public class RegularExpressionMatchI {

    public static void main(String[] args) {

        RegularExpressionMatchI obj = new RegularExpressionMatchI();
        String A = "aab";
        String B = "c*a*b";
        int result = obj.isMatch(A, B);
        System.out.println(result);
    }

    public int isMatch(final String string, final String pattern) {
        int n = string.length();
        int m = pattern.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {

                if (i == m && j == n) {
                    dp[i][j] = true;
                } else if (i == m) {
                    dp[i][j] = false;
                } else if (j == n) {
                    char ch = pattern.charAt(i);
                    if (ch == '*') {
                        dp[i][j] = dp[i + 1][j];
                    } else {
                        dp[i][j] = false;
                    }

                } else {
                    char pp = pattern.charAt(i);
                    char ss = string.charAt(j);

                    if (pp == ss || pp == '?') {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else if (pp == '*') {
                        for (int k = j; k <= n; k++) {
                            dp[i][j] = dp[i][j] || dp[i + 1][k];
                            if (dp[i][j]) break;
                        }
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }

        return dp[0][0] ? 1 : 0;
    }
}
