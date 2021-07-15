package com.interviewbit.dp.knapsackvariation;

import com.interviewbit.utils.ArrayUtils;

import java.util.Arrays;

public class EqualSumPartition {

    public static void main(String[] args) {

        EqualSumPartition obj = new EqualSumPartition();
        int[] ints = ArrayUtils.asArrays(1, 5, 5, 11);
        System.out.println(obj.solveIterative(ints));
    }


    public int equalPartition(int arr[]) {

        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        if (sum % 2 != 0) return 0;

        int[][] dp = new int[n + 1][sum + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return recursive(arr, sum/2, dp, n);
    }

    public int recursive(int[] arr, int sum, int[][] dp, int n) {

        if (n == 0) return 0;
        if (sum == 0) return 1;

        if (dp[n][sum] != -1) return dp[n][sum];

        if (arr[n - 1] <= sum) {
            return dp[n][sum] = (recursive(arr, sum - arr[n - 1], dp, n - 1)
                    | recursive(arr, sum, dp, n - 1)) >= 1 ? 1 : 0;
        } else {
            return dp[n][sum] = recursive(arr, sum, dp, n - 1);
        }
    }

    public int solveIterative(int[] arr){
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) return 0;
        sum = sum / 2;

        boolean[][] dp = new boolean[n + 1][sum + 1];

        for(int i = 0; i <= sum; i++){
            dp[0][i] = false;
        }

        for(int i = 0; i <= n; i++){
            dp[i][0] = true;
        }


        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){
                if( arr[i - 1] <= j){
                  dp[i][j] = dp[i - 1][j] || dp[ i - 1][ j - arr[i - 1]];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
//        ArrayUtils.printArray(dp);
        return dp[n][sum] ? 1 : 0;
    }


}
