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

    public boolean isMatchOptimized(String s, String p) {

        int n = p.length();
        int m = s.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        for(int i = n; i >= 0; i--){
            for(int j = m; j >= 0; j--){
                if( i == n && j == m){
                    dp[i][j] = true;
                }
                else if(i == n){}
                else if(j == m){
                    if( p.charAt(i) == '*')
                        dp[i][j] = dp[i + 1][j];
                }
                else {
                    char str = s.charAt(j);
                    char pat = p.charAt(i);

                    if( str == pat || pat == '?')
                        dp[i][j] = dp[i + 1][j + 1];
                    else if ( pat == '*'){
                        dp[i][j] = dp[i][j + 1] || dp[i + 1][j];
                    }
                }
            }
        }

        return dp[0][0];
    }
    /*

    Solving Basics.

        See if your current char in string matches the current char in pattern
        look diagonally down. To see if curr len + 1 in both the string were
        matching (dp[i + 1][j + 1]) or( if pattern is also ? then same case)

        If the pattern is '*'
        then see the pattern can match any number of character so
        see if removing the '*' is helping ?
        it means dp[i + 1][j]

        or if '*' becomes the next character then it is helping.
            dp[i + 1][j + 1]

        or if '*' becomes one more character then it is helping
        dp[i + 1][j + 2];

        go on till the end.
        Making sense right.

        See if '*' becomes next character in the string then the remaining
        character in the pattern should match with all remaining
        character from string after this next character right ?
        which will be store in dp[i + 1][j + 1] and so on.
-------------------------------------------------------------------------
        The Reason you are just able to do
        dp[i][j] = dp[i][j + 1] || dp[i + 1][j]
        instead of

        dp[i][j] = for(k --> in range(j,m)) dp[i + 1][k]

        is because
        for(k --> in range(j + 1, m) is actually represented
            by dp[i][j + 1]
        This was just calculated previously to current Value
        right ?
        Think once. ( What range were you calculating when you were in dp[i][j + 1]
        You will get to understand.

     */
}
