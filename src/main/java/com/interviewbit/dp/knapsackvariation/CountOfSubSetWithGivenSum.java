package com.interviewbit.dp.knapsackvariation;

import com.interviewbit.utils.ArrayUtils;

public class CountOfSubSetWithGivenSum {

    public static void main(String[] args) {

        CountOfSubSetWithGivenSum obj = new CountOfSubSetWithGivenSum();
        int[] ints = ArrayUtils.asArrays(1, 2, 3, 4, 5, 6, 7, 8, 9);

        int result = obj.solve(ints, 9);
        System.out.println(result);
    }

    public int solve(int[] arr, int sum) {

        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i <= sum; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }
}