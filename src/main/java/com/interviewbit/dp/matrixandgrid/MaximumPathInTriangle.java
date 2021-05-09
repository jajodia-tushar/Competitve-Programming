package com.interviewbit.dp.matrixandgrid;

public class MaximumPathInTriangle {
    public static void main(String[] args) {

        MaximumPathInTriangle obj = new MaximumPathInTriangle();
        int[][] ints = {{3, 0, 0, 0}, {7, 4, 0, 0}, {2, 4, 6, 0}, {8, 5, 9, 3}};
        int result = obj.solve(ints);
        System.out.println(result);
    }

    public int solve(int[][] A) {

        int n = A.length;
        int[] dp = new int[n];

        for (int i = 0; i < A[n - 1].length; i++) {
            dp[i] = A[n - 1][i];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < A[i].length && A[i][j] != 0; j++) {
                dp[j] = A[i][j] + Math.max(dp[j], dp[j + 1]);
            }
        }

        return dp[0];

    }


}
