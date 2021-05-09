package com.interviewbit.dp.stocks;

import com.interviewbit.utils.ArrayUtils;

/*
    Say you have an array, A, for which the ith element is the price of a given stock on day i.
    Design an algorithm to find the maximum profit. You may complete at most 2 transactions.
    Return the maximum possible profit.
    Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStocksIII {
    public static void main(String[] args) {

        BestTimeToBuyAndSellStocksIII obj = new BestTimeToBuyAndSellStocksIII();
        int[] ints = ArrayUtils.asArrays(1, 4, 5, 2, 4);
        int result = obj.maxProfit(ints);
        System.out.println(result);
    }

    public int maxProfit(final int[] A) {

        int n = A.length;
        if (n == 0) return 0;
        int lowTillNow = A[0];
        int[] low = new int[n];

        for (int i = 1; i < n; i++) {
            lowTillNow = Math.min(lowTillNow, A[i]);
            int profit = A[i] - lowTillNow;
            low[i] = Math.max(low[i - 1], profit);
        }

        int highTillNow = A[n - 1];
        int[] high = new int[n];


        for (int i = n - 2; i >= 0; i--) {
            highTillNow = Math.max(highTillNow, A[i]);
            int profit = highTillNow - A[i];
            high[i] = Math.max(high[i + 1], profit);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, low[i] + high[i]);
        }

        return ans;
    }
}
