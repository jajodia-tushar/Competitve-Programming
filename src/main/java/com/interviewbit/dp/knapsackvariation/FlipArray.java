package com.interviewbit.dp.knapsackvariation;

import com.interviewbit.utils.ArrayUtils;

public class FlipArray {

    public static void main(String[] args) {

        FlipArray obj = new FlipArray();
        int[] ints = ArrayUtils.asArrays(14, 10, 4);
        int min = obj.findMin(ints);
        System.out.println(min);
    }

    public int findMin(int arr[]) {

        int n = arr.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i <= sum; i++) {
            dp[0][i] = Integer.MAX_VALUE - 1;
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i - 1][j - arr[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int minValue = Integer.MAX_VALUE;
        int flip = 0;
        for (int i = 0; i <= sum / 2; i++) {
            if (dp[n][i] != Integer.MAX_VALUE - 1) {
                int value = sum - 2 * i;
                if(minValue > value){
                    minValue = value;
                    flip = dp[n][i];
                }
            }
        }
        return flip;
    }

}
