package com.interviewbit.dp;

import com.interviewbit.utils.ArrayUtils;

/*
    Implement regular expression matching with support for '.' and '*'.
    '.' Matches any single character.
    '*' Matches zero or more of the preceding element.
    The matching should cover the entire input string (not partial).
    The function prototype should be:
 */
public class RegularExpressionMatchII {

    public static void main(String[] args) {

        RegularExpressionMatchII obj = new RegularExpressionMatchII();
        String A = "ab";
        String B = ".*";
        int result = obj.isMatch(A, B);
        System.out.println(result);
    }

    public int isMatch(final String A, final String B) {
        int s = A.length();
        int p = B.length();

        boolean[][] dp = new boolean[p + 1][s + 1];

        for (int i = 0; i <= p; i++) {
            for (int j = 0; j <= s; j++) {

                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    char ch = B.charAt(i - 1);
                    if (ch == '*') {
                        dp[i][j] = dp[i - 2][j];
                    } else {
                        dp[i][j] = false;
                    }

                } else {
                    char pattern = B.charAt(i - 1);
                    char string = A.charAt(j - 1);

                    if (pattern == string || pattern == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (pattern == '*') {
                        dp[i][j] = dp[i - 2][j];
                        char prePattern = B.charAt(i - 2);
                        if (prePattern == '.' || prePattern == string) {
                            dp[i][j] = dp[i][j] || dp[i][j - 1];
                        }

                        // Why are we checking for dp[i][j - 1]
                        // Try to remember the case when we were
                        // matching mis with mis*.
                        // mis* can be mi or miss*.
                        // Now to match mis with miss* we see last s of mis is matching with first s for miss*
                        // so now matching mi with mis* which can be found in dp[i][j - 1]
                        //

                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }

//        ArrayUtils.printArray(dp);
        return dp[p][s] ? 1 : 0;
    }

}
