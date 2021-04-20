package com.interviewbit.dp.knapsackvariation;


import java.util.Arrays;

public class ZeroOneKnapsackProblem {

    public static void main(String[] args) {

        ZeroOneKnapsackProblem obj = new ZeroOneKnapsackProblem();
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(obj.solveIterative(W, wt, val, n));
    }

    public int knapsack(int W, int wt[], int val[], int n) {

        int[][] dp = new int[n + 1][W + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return solveRecursive(W, wt, val, dp, n);
    }

    public int solveRecursive(int weight, int wt[], int value[], int[][] dp, int n) {

        if (n <= 0 || weight == 0) return 0;
        if (dp[n][weight] != -1) return dp[n][weight];

        if (wt[n - 1] <= weight) {
            dp[n][weight] = Math.max(solveRecursive(weight, wt, value, dp, n - 1),
                    value[n - 1] + solveRecursive(weight - wt[n - 1], wt, value, dp, n - 1));
        } else {
            return dp[n][weight] = solveRecursive(weight, wt, value, dp, n - 1);
        }
        return dp[n][weight];
    }

    public int solveIterative(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n + 1][W + 1];
        for(int i = 0 ; i <= n; i++){
            for(int j = 0; j <= W; j++){

                if( i == 0 || j == 0){
                    dp[i][j] = 0;
                    continue;
                }

                // Check if Current Weight item can be picked.
                // If Yes then See if I pick this item then Profit is maximum
                // or if I don't pick then.
                if( wt[i - 1] <= j){
                    dp[i][j] = Math.max(val[i - 1]+ dp[i -1][j - wt[i - 1]],dp[i - 1][j]);
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
                // Above Statement says that if I am not able to pick the item. then we check for next item.
            }

        }
        return dp[n][W];
    }


}
