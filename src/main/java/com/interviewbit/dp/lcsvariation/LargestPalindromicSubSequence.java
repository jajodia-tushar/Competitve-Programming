package com.interviewbit.dp.lcsvariation;


/*
Given a sequence, find the length of the longest palindromic subsequence in it.
 */
public class LargestPalindromicSubSequence {

    public static void main(String[] args) {
        LargestPalindromicSubSequence obj = new LargestPalindromicSubSequence();
        String A = "GEEKSFORGEEKS";
        int result = obj.getLongestPalindromicSubSequence(A);
        System.out.println(result);
    }


    public int getLongestPalindromicSubSequence(String A){
        // This Question is Similar to finding LCS.
        // Second String is going to be the reverse of A.

        // Here we could have used the String B by reversing A.
        // But Why to increase the cost.
        int n = A.length();
        int m = n;

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){

                if( i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else if( A.charAt(i - 1) == A.charAt(n - j)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }




}
