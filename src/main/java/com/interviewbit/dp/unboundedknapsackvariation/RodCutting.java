package com.interviewbit.dp.unboundedknapsackvariation;

import com.interviewbit.utils.ArrayUtils;

import java.util.Arrays;

public class RodCutting {

    public static void main(String[] args) {
        RodCutting obj = new RodCutting();
        int[] price = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        int profit1 = obj.solveIterative(price);
        int profit2 = obj.cutRod(price);
        System.out.println(profit1);
        System.out.println(profit2);
    }

    public int cutRod(int price[]) {
        int n = price.length;
        /*
            The cell at [i,j] represents the maximum
            amount of profit that can be earned
            from selling a rod of initial length j.
            One is able to choose the cuts from an array of 0 to i.
        */
        int[][] dp = new int[n + 1][n + 1];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);
        int recursive = recursive(price, n, n, dp);
        ArrayUtils.printArray(dp);
        return recursive;
    }

    public int recursive(int[] price, int i, int j, int[][] dp) {

        if (i == 0 || j == 0)
            return 0;

        // Here j represents the Current Size of the Rod
        // i <= j means that i am able to make a cut the rod of i length.
        // Example if Rod is 5 meter long and i is 2 meaning that I am
        // able to cut a 2 meter long Rod and check of remaining 5 - 2 length. rod.

        if (i <= j) {
            if (dp[i][j] == -1)
                dp[i][j] = Math.max(price[i - 1] + recursive(price, i, j - i, dp), recursive(price, i - 1, j, dp));
        } else {
            dp[i][j] = recursive(price, i - 1, j, dp);
        }

        return dp[i][j];
    }

    public int solveIterative(int[] price) {

        int n = price.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i - 1][j - i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][n];
    }
}
