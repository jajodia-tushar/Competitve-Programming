package com.interviewbit.dp.stocks;

import com.interviewbit.utils.ArrayUtils;

/*
    Say you have an array, A, for which the ith element is the price of a given stock on day i.
    Design an algorithm to find the maximum profit.
    You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
    However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStocksII {
    public static void main(String[] args) {

        BestTimeToBuyAndSellStocksII obj = new BestTimeToBuyAndSellStocksII();
        int[] ints = ArrayUtils.asArrays(1, 4, 5, 2, 4);
        int result = obj.maxProfit(ints);
        System.out.println(result);
    }

    public int maxProfit(final int[] A) {

        int n = A.length;
        if (n == 0) return 0;
        int buyIndex = 0;
        int sellIndex = 0;
        int currentProfit = 0;

        for (int i = 1; i < n; i++) {
            if (A[i] >= A[sellIndex]) {
                sellIndex = i;
            } else {
                currentProfit += (A[sellIndex] - A[buyIndex]);
                sellIndex = i;
                buyIndex = i;
            }
        }
        currentProfit += (A[sellIndex] - A[buyIndex]);
        return currentProfit;
    }
}
