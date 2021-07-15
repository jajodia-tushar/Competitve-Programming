package com.interviewbit.dp.knapsackvariation;

import com.interviewbit.utils.ArrayUtils;

public class MinimumSubSetSumDifference {

    public static void main(String[] args) {

        MinimumSubSetSumDifference obj = new MinimumSubSetSumDifference();
        int[] ints = ArrayUtils.asArrays(1, 6, 11, 5);
        int min = obj.findMin(ints);
        System.out.println(min);
    }

    public int findMin(int arr[]) {

        int n = arr.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= sum; i++) {
            dp[0][i] = false;
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        ArrayUtils.printArray(dp);

        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i <= sum / 2; i++) {
            if (dp[n][i]) {
                int value = sum - 2 * i;
                minValue = Math.min(value, minValue);
            }
        }
        return minValue;
    }

}
