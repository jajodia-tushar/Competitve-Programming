package com.interviewbit.dp;

import java.util.Arrays;

public class EditDistance {

    public static void main(String[] args) {
        EditDistance obj = new EditDistance();

        String A = "aaa";
        String B = "aa";

        System.out.println(obj.minDistance(A,B));

    }

    public int minDistance(String A, String B) {

        int i = A.length();
        int j = B.length();

        int[][] dp = new int[i + 1][j + 1];

        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }

        return recursive(A,B,i,j,dp);

    }

    public int recursive(String A, String B, int i, int j, int[][] dp) {

        if( i == 0 && j == 0)
            return 0;

        if( i == 0)
            return j;
        if( j == 0)
            return i;

        char chA = A.charAt(i - 1);
        char chB = B.charAt(j - 1);

        if( dp[i][j] != -1) return dp[i][j];

        if (chA != chB) {
            // replace
            int replace = 1 + recursive(A, B, i - 1, j - 1, dp);
            //Delete
            int delete = 1 + recursive(A, B, i - 1, j, dp);
            // insert
            int insert  = 1 + recursive(A, B, i, j - 1, dp);
            dp[i][j] = Math.min(replace,Math.min(delete,insert));
        }
        else{
            dp[i][j] = recursive(A,B,i - 1, j - 1,dp);
        }

        return dp[i][j];
    }

    public int minDistanceIterative(String A, String B) {

        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0 ; i < n; i++){
            dp[i][0] = i;
        }

        for(int i = 0; i < m; i++){
            dp[0][i] = i;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){

                char charA = A.charAt(i - 1);
                char charB = B.charAt(j - 1);
                if(charA != charB){
                    int replace = dp[i - 1][j - 1];
                    int insert = dp[i - 1][j];
                    int delete = dp[i][j - 1];
                    dp[i][j] = Math.min(replace,Math.min(insert,delete)) + 1;


                }
                else{
                    dp[i][j] = dp[i - 1][j - 1];
                }



            }

        }

        return dp[n][m];
    }
}
