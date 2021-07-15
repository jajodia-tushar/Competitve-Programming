package com.interviewbit.dp.mcmvariation;

import com.interviewbit.utils.ArrayUtils;

import java.util.Arrays;

public class PrintMCM {
    static char name = 'A';

    public static void main(String[] args) {
        PrintMCM obj = new PrintMCM();
        int[] ints = ArrayUtils.asArrays(10, 20, 30, 40);
        int n = ints.length;

        int[][] dp = new int[n][n];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        // for Storing the Value of K Kp is Used
        int[][] kp = new int[n][n];
        for (int[] a : kp) {
            Arrays.fill(a, -1);
        }

        int result = obj.solveRecursive(ints, 1, n - 1, dp, kp);
        int resultIterative = obj.solveIterative(ints);
        System.out.println(result);
        System.out.println(resultIterative);
        obj.printParenthesis(1, n - 1, kp);
    }

    public int solveRecursive(int[] arr, int i, int j, int[][] dp, int[][] kp) {

        if (i >= j) {
            return dp[i][j] = 0;
        }
        if (dp[i][j] != -1) return dp[i][j];

        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = solveRecursive(arr, i, k, dp, kp) + solveRecursive(arr, k + 1, j, dp, kp) +
                    arr[i - 1] * arr[k] * arr[j];
            if (temp < dp[i][j]) {
                dp[i][j] = Math.min(temp, dp[i][j]);
                kp[i][j] = k;
            }
        }
        return dp[i][j];
    }

    public int solveIterative(int[] arr) {

        int n = arr.length;
        int[][] dp = new int[n][n];
        int[][] kp = new int[n][n];

        // This We are doing for Length 1 Matrix
        for(int i = 0; i < n; i++){
            dp[i][i] = 0;
        }

        for(int l = 2; l < n; l++){
            for(int i = 1; i <= n - l; i++) {
                int j = i + l - 1;
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int value = dp[i][k] + dp[k+1][j] + (arr[i - 1] * arr[k] * arr[j]);
                    if( value < min){
                        min = Math.min(value,min);
                        kp[i][j] = k;
                    }
                }
                dp[i][j] = min;
            }
        }

        ArrayUtils.printArray(kp);
        return dp[1][n - 1];
    }

    void printParenthesis(int i, int j, int[][] bracket) {

        // If only one matrix left in current segment
        if (i == j) {
            System.out.print(name++);
            return;
        }
        System.out.print("(");
        printParenthesis(i, bracket[i][j], bracket);
        printParenthesis(bracket[i][j] + 1, j, bracket);
        System.out.print(")");
    }
}
