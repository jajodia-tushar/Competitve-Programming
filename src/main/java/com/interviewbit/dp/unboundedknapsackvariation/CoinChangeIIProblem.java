package com.interviewbit.dp.unboundedknapsackvariation;


import com.interviewbit.utils.ArrayUtils;

import java.util.Arrays;

// Find the Minimum Number of Coins
public class CoinChangeIIProblem {

    public static void main(String[] args) {
        CoinChangeIIProblem obj = new CoinChangeIIProblem();
        int[] ints = ArrayUtils.asArrays(5, 5, 2);

        int result = obj.iterative(ints, 7);
        System.out.println(result);
    }

    public int solveRecursive(int[] arr, int sum) {

        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];

        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return (int) recursive(arr, n, sum, dp);

    }

    public int recursive(int[] arr, int i, int j, int[][] dp) {

        if (j == 0) return 0;
        if (i == 0) return Integer.MAX_VALUE - 1;

        if (arr[i - 1] == j) return 1;

        if (arr[i - 1] <= j) {
            if (dp[i][j] == -1) {
                dp[i][j] = Math.min(1 + recursive(arr, i, j - arr[i - 1], dp), recursive(arr, i - 1, j, dp));
            }
        } else {
            dp[i][j] = recursive(arr, i - 1, j, dp);
        }
        return dp[i][j];
    }


    public int iterative(int[] arr, int sum) {

        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];
        Arrays.sort(arr);
        for (int i = 0; i <= sum; i++)
            dp[0][i] = Integer.MIN_VALUE + 1000;

        for (int i = 0; i <= n; i++)
            dp[i][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {

                if (arr[i - 1] <= j) {
                    dp[i][j] = Math.max(1 + dp[i][j - arr[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum] == Integer.MAX_VALUE - 1 ? -1 : dp[n][sum];
    }
}
