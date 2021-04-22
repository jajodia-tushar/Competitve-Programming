package com.interviewbit.dp.lcsvariation;

/*
Given a string, find the longest substring which is palindrome.
 */
public class LongestPalindromicSubString {

    public static void main(String[] args) {

        LongestPalindromicSubString obj = new LongestPalindromicSubString();
        int result = obj.longestPalindromicSubString("forgeeksskeegfor");
        System.out.println(result);

    }
    // This Question is not as LPS. where we needed Longest Palindromic SubSequence.
    // The Technique used here can be used to solve various version of same problem.

    public int longestPalindromicSubString(String A) {

        int n = A.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int max = 1;
        for (int i = 0; i < n - 1; i++) {
            if (A.charAt(i) == A.charAt(i + 1)) {
                dp[i][i + 1] = true;
                max = 2;
            }
        }

        for (int k = 3; k <= n; k++) {
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1;
                if (dp[i + 1][j - 1] && A.charAt(i) == A.charAt(j)) {
                    dp[i][j] = true;
                    if (k > max) {
                        max = k;
                    }
                }


            }
        }

        return max;
    }


}
