package com.interviewbit.dp.stocks;

import com.interviewbit.utils.ArrayUtils;

/*
    Say you have an array, A, for which the ith element is the price of a given stock on day i.
    If you were only permitted to complete at most one transaction
    (i.e, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
    Return the maximum possible profit.
 */
public class BestTimeToBuyAndSellStocksI {
    public static void main(String[] args) {

        BestTimeToBuyAndSellStocksI obj = new BestTimeToBuyAndSellStocksI();
        int[] ints = ArrayUtils.asArrays(1, 4, 5, 2, 4);
        int result = obj.maxProfit(ints);
        System.out.println(result);
    }

    public int maxProfit(final int[] A) {
        int n = A.length;
        if (n == 0) return 0;
        int[] minPrefix = new int[n];
        minPrefix[0] = A[0];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            minPrefix[i] = Math.min(A[i], minPrefix[i - 1]);
            int currProfit = A[i] - minPrefix[i];
            max = Math.max(currProfit, max);
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    public int maxProfitOptimized(final int[] A) {

        int n = A.length;
        if (n == 0) return 0;
        int min = A[0];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            min = Math.min(min, A[i]);
            int currProfit = A[i] - min;
            max = Math.max(currProfit, max);
        }

        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
