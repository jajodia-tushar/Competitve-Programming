package com.interviewbit.dp.stocks;

import com.interviewbit.utils.ArrayUtils;

/*
    Given an array of integers A of size N in which ith element is the price of the stock on day i.
    You can complete atmost B transactions.
    Find the maximum profit you can achieve.
    NOTE: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStocksIV {
    public static void main(String[] args) {

        BestTimeToBuyAndSellStocksIV obj = new BestTimeToBuyAndSellStocksIV();
        int[] ints = ArrayUtils.asArrays(1, 4, 5, 2, 4);
        int result = obj.solve(ints, 5);
        System.out.println(result);
    }

    public int solve(int[] A, int B) {

        int n = A.length;
        if (B > n) B = n;


        int[][] dp = new int[2][n + 1];

        for (int i = 1; i <= B; i++) {
            int maxPreviousDay = Integer.MIN_VALUE;
            for (int j = 1; j <= n; j++) {
                maxPreviousDay = Math.max(dp[0][j - 1] - A[j - 1], maxPreviousDay);
                dp[1][j] = Math.max(dp[1][j - 1], maxPreviousDay + A[j - 1]);
            }

            dp[0] = dp[1];
        }

        return dp[1][n];

    }
}
