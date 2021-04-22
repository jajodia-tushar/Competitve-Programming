package com.interviewbit.dp.mcmvariatino;

import com.interviewbit.utils.ArrayUtils;

import java.util.Arrays;

public class MatrixChainMultiplication {

    public static void main(String[] args) {

        int[] arrays = ArrayUtils.asArrays(1, 2, 3, 4);
        int result = calculateMCM(arrays);
        System.out.println(result);
    }

    private static int calculateMCM(int[] arrays) {
        int n = arrays.length;
        int[][] dp = new int[n][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return calculate(arrays, 1, n - 1, dp);
    }

    private static int calculate(int[] arrays, int i, int j, int[][] dp) {

        if (i >= j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        for (int k = i; k < j; k++) {
            int currentValue = calculate(arrays, i, k, dp) + calculate(arrays, k + 1, j, dp) +
                    arrays[i - 1] * arrays[k] * arrays[j];
            if(dp[i][j] == -1) dp[i][j] = currentValue;
            else dp[i][j] = Math.min(dp[i][j], currentValue);
        }

        return dp[i][j];
    }


}
