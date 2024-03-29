package com.interviewbit.dp.mcmvariation;

import java.util.Arrays;

public class MCM2 {

    public static void main(String[] args) {

        MCM2 obj = new MCM2();
        int[] arr = {10, 20, 30, 40};
        int n = arr.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        int result1 = obj.calculateMCM(arr, 1, n - 1, dp);
        int result2 = obj.calculateMCMIterative(arr);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println("----------------------");
        int[] ints = {40, 20, 30, 10, 30};
        int result  = matrixMultiplication(5, ints);
        System.out.println(result);
    }

    public int[][] getMCMPartitionArray(int[] arr) {

        int n = arr.length;
        int[][] dp = new int[n + 1][n + 1];
        int[][] kp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        this.calculateMCMWithKP(arr, 1, n - 1, dp, kp);
        return kp;

    }

    public int calculateMCMWithKP(int[] arr, int i, int j, int[][] dp, int[][] kp) {

        if (i >= j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int value = calculateMCMWithKP(arr, i, k, dp, kp) + calculateMCMWithKP(arr, k + 1, j, dp, kp)
                    + (arr[i - 1] * arr[k] * arr[j]);
            if (min > value) {
                min = value;
                kp[i][j] = k;
            }
        }
        return dp[i][j] = min;
    }

    public int calculateMCM(int[] arr, int i, int j, int[][] dp) {

        if (i >= j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int value = calculateMCM(arr, i, k, dp) + calculateMCM(arr, k + 1, j, dp)
                    + (arr[i - 1] * arr[k] * arr[j]);
            min = Math.min(value, min);
        }
        return dp[i][j] = min;
    }

    public int calculateMCMIterative(int[] arr) {

        int n = arr.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][i] = 0;
        }

        for (int l = 2; l < n; l++) {
            for (int i = 1; i <= n - l; i++) {
                int j = i + l - 1;
                int minValue = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {

                    int value = dp[i][k] + dp[k + 1][j] +
                            (arr[i - 1] * arr[k] * arr[j]);

                    minValue = Math.min(value, minValue);
                }
                dp[i][j] = minValue;
            }
        }
        return dp[1][n - 1];
    }

    static int matrixMultiplication(int N, int arr[]) {
        int[][] dp = new int[N][N];

        for (int[] a : dp) {
            Arrays.fill(a, 99999);
        }

        for (int i = 0; i < N; i++) {
            dp[i][i] = 0;
        }

        for (int size = 2; size < N; size++) {
            for (int i = 1; i < N - size; i++) {
                int j = i + size - 1;
                for (int k = i; k < j; k++) {
                    int otherValue = (dp[i][k] + dp[k + 1][j] + (arr[i - 1] * arr[k] * arr[j]));
                    dp[i][j] = Math.min(dp[i][j], otherValue);
                    System.out.println(i + "," + j + "--> " + otherValue);
                }
            }
        }

        return dp[1][N - 1];
    }


}
