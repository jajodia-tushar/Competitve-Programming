package com.leetcode.important;

import java.util.Arrays;

/*
    Given a string s, return the number of distinct non-empty subsequences of s.
    Since the answer may be very large, return it modulo 109 + 7.
    A subsequence of a string is a new string that is formed from the original string by
    deleting some (can be none) of the characters without disturbing the relative positions
    of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not.

    Example 1:
    Input: s = "abc"
    Output: 7
    Explanation: The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc".

    Example 2:
    Input: s = "aba"
    Output: 6
    Explanation: The 6 distinct subsequences are "a", "b", "ab", "aa", "ba", and "aba".

    Example 3:
    Input: s = "aaa"
    Output: 3
    Explanation: The 3 distinct subsequences are "a", "aa" and "aaa".
 */
public class DistinctSubsequencesII {

    public static void main(String[] args) {

        DistinctSubsequencesII obj = new DistinctSubsequencesII();
        int result = obj.distinctSubseqII("abcsad");
        System.out.println(result);
    }

    public int distinctSubseqII(String s) {

        int n = s.length();
        long[] dp = new long[n + 1];
        int[] chArray = new int[26];
        Arrays.fill(chArray,-1);
        int mod = 1000_000_007;

        dp[0] = 1;

        for(int i = 1; i <= n; i++){
            int index = s.charAt(i - 1) - 'a';
            dp[i] = (2 * dp[i - 1] % mod) % mod;
            if(chArray[index] != -1){
                dp[i] = dp[i] - dp[chArray[index] - 1];
            }
            dp[i] = dp[i] % mod;
            chArray[index] = i;
        }
        dp[n]--;

        if( dp[n] < 0) dp[n] += mod;
        return (int)(dp[n]) % mod;

    }
}

/*
      Look Copy Pep Coding has Explained this very nicely

 */