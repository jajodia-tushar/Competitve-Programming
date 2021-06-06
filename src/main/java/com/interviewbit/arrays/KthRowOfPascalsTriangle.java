package com.interviewbit.arrays;


import com.interviewbit.utils.ArrayUtils;

/*
Given an index k, return the kth row of the Pascal’s triangle.
Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.
Example:

Input : k = 3

Return : [1,3,3,1]
 NOTE : k is 0 based. k = 0, corresponds to the row [1].
Note:Could you optimize your algorithm to use only O(k) extra space?
 */
public class KthRowOfPascalsTriangle {

    public static void main(String[] args) {
        KthRowOfPascalsTriangle obj = new KthRowOfPascalsTriangle();
        int[] result = obj.getRowSpaceOptimized(4);
        ArrayUtils.printArray(result);
    }

    public int[] getRow(int A) {
        int[][] dp = new int[A + 1][A + 1];

        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= A; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else if (i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[A];
    }

    public int[] getRowSpaceOptimized(int A) {

        int[] result = new int[A + 1];
        result[0] = 1;

        for (int i = 1; i <= A; i++) {
            result[i] = result[i - 1] * (A - i + 1) / i;
        }

        return result;
    }
}

/*

    Read the following lines very carefully,
    Kth Row of the Pascal Triangle is nothing but the Binomial Coefficients.

    So We can use DP to easily generate NcR value required.
    We will use this Famous Formula.

    nCr = (n - 1)C(r - 1) + (n - 1)C(r);
    and we know if n == 0 or r == 0 nCr = 1;
    and if n == r then also nCr == 1;
    So we have used the same formula in the first Case.

    In the second Case they are asking whether Space can be optimized.
    If we can be able to use O(K) or constant Space.

    So the Idea is.

    to use another Formula
    nCr = nC(r - 1) * (n - r + 1)/r
    how did we get this formula. Try to solve you will be able to do it no tension at all.
    just remember there is n - r + 1 not - 1


    So in the second Method we are using this technique

 */
