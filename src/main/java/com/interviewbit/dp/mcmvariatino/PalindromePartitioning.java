package com.interviewbit.dp.mcmvariatino;

import java.util.Arrays;

public class PalindromePartitioning {
    public static void main(String[] args) {

        PalindromePartitioning obj = new PalindromePartitioning();
        String str = "abbac";

        int result = obj.minimumPartition(str);
        System.out.println(result);
    }

    public int minimumPartition(String str){
        int n = str.length();

        int[][] dp = new int[n][n];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
//        return calculateMinimumPartition(str,0,n-1);
        return calculateMinimumPartitionOptimized(str,0,n-1,dp);
    }

    private int calculateMinimumPartition(String str, int i, int j) {
        if( i >= j) return 0;
        if( isPalindrome(str,i,j)) return 0;
        int ans = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            int tempAns = calculateMinimumPartition(str,i,k) + calculateMinimumPartition(str,k+1,j) + 1;
            ans = Math.min(ans,tempAns);
        }
        return ans;
    }

    public boolean isPalindrome(String str, int i, int j){
        if( i > j) return false;
        while(i < j){
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    private int calculateMinimumPartitionOptimized(String str, int i, int j,int[][] dp) {
        if( i >= j) return 0;
        if( isPalindrome(str,i,j)) return 0;
        if( dp[i][j] != -1) return dp[i][j];

        for(int k = i; k < j; k++){
            int tempAns = calculateMinimumPartitionOptimized(str,i,k,dp) + calculateMinimumPartitionOptimized(str,k+1,j,dp) + 1;
            if(dp[i][j] == -1) dp[i][j] = tempAns;
            else dp[i][j] = Math.min(dp[i][j],tempAns);
        }
        return dp[i][j];
    }







}
