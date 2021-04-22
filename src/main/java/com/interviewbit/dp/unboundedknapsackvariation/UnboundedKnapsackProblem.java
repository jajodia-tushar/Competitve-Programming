package com.interviewbit.dp.unboundedknapsackvariation;


import java.util.Arrays;

public class UnboundedKnapsackProblem {

    public static void main(String[] args) {

        UnboundedKnapsackProblem obj = new UnboundedKnapsackProblem();
        int W = 100;
        int[] val = {10, 30, 20};
        int[] wt = {5, 10, 15};
        int n = val.length;

        int[][] dp = new int[n  + 1][W + 1];
        for(int[] a : dp) Arrays.fill(a, - 1);
        System.out.println(obj.solveIterative(W, n, val, wt));
    }

    public int unboundedKnapsack(int W, int n, int[] val, int[] wt, int[][] dp) {
        if (n == 0 || W == 0) return 0;

        if (dp[n][W] != -1) return dp[n][W];

        if (wt[n - 1] <= W) {
            return dp[n][W] = Math.max(val[n - 1] + unboundedKnapsack(W - wt[n - 1], n, val, wt, dp)
                    , unboundedKnapsack(W, n - 1, val, wt, dp));
        } else {
            return dp[n][W] = unboundedKnapsack(W, n - 1, val, wt, dp);
        }
    }

    public int solveIterative(int W, int n, int[] val, int[] wt){

        int[][] dp = new int[n  + 1][W + 1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= W; j++){
                if( wt[i - 1] <= j){
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]],dp[i - 1][j]);
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }
}
