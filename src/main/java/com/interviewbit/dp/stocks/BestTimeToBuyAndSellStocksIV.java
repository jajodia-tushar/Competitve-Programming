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

    public int solve(int[] prices, int k) {

        int n = prices.length;
        int[][] dp = new int[k + 1][n + 1];

        if (n == 0) return 0;

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                int max = dp[i][j - 1];
                for(int x = 1; x < j; x++){
                    max = Math.max(max,dp[i - 1][x] + prices[j - 1] - prices[x - 1]);
                }
                dp[i][j] = max;
            }
        }
        return dp[k][n];
    }

    public int solveTimeOptimized(int[] prices, int k) {

        int n = prices.length;
        int[][] dp = new int[k + 1][n];

        if (n == 0) return 0;


        for (int i = 1; i <= k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j < n; j++) {
                max = Math.max(max, dp[i - 1][j - 1] - prices[j - 1]);
                dp[i][j] = Math.max(dp[i][j - 1], max + prices[j]);
            }
        }
        return dp[k][n - 1];
    }

    public int solveTimeAndSpaceOptimized(int[] A, int B) {

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

/*
    Basic Idea to solve this problem is see.
    If you want to make most profit today by making t transactions then
    the max can be equal to max of making t transaction previous day
    or making a transaction today and max making t - 1 transaction on previous days. [ Notice the day and days]

    So we loop on previous days to find the maximum value of the t - 1 transaction and we make the final
    transaction between that day and today.

    Now,
    See we wanted the value maximum value of these from the previous days right
    to optimize the solution from N^3 to N^2
    So what we can do is for every new transaction we can keep track of this value.
    the maximum value of this variable will be used in the final answer.

    dp[i - 1][x] - prices[x - 1]

    This is perfectly making sense to me right now.

 */
