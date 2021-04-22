package com.interviewbit.dp.unboundedknapsackvariation;

import com.interviewbit.utils.ArrayUtils;

import java.util.Arrays;


// Find all number of ways to make the given sum
public class CoinChangeIProblem {

    public static void main(String[] args) {

        CoinChangeIProblem obj = new CoinChangeIProblem();
        int[] ints = ArrayUtils.asArrays(1, 2, 3);

        int result = obj.iterative(ints, 5);
        System.out.println(result);

    }

    public int countNumberOfWays(int[] arr, int sum) {

        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];

        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return recursive(arr, n, sum, dp);
    }

    public int recursive(int[] arr, int n, int sum, int[][] dp) {

        if (sum == 0)
            return 1;
        if (n == 0)
            return 0;

        int value = arr[n - 1];

        if (value <= sum) {
            if (dp[n][sum] == -1)
                dp[n][sum] = recursive(arr, n, sum - value, dp) + recursive(arr, n - 1, sum, dp);
        } else {
            dp[n][sum] = recursive(arr, n - 1, sum, dp);
        }

        return dp[n][sum];
    }

    public int iterative(int[] arr, int sum){

        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];

        for(int i = 0; i <= sum ; i++)
            dp[0][i] = 0;

        for(int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){

                if( arr[i - 1] <= j){
                    dp[i][j] = dp[i][j -  arr[i - 1]] + dp[i - 1][j];
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }





}
