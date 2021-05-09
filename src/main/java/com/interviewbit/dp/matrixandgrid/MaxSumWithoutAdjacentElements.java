package com.interviewbit.dp.matrixandgrid;

public class MaxSumWithoutAdjacentElements {

    public static void main(String[] args) {

        MaxSumWithoutAdjacentElements obj = new MaxSumWithoutAdjacentElements();
        int[][] ints = {{1, 2, 3, 4}, {2, 3, 4, 5}};
        int result = obj.adjacent(ints);
        System.out.println(result);
    }

    public int adjacent(int[][] A) {

        int n = A[0].length;
        int[] newA = new int[n];

        for (int i = 0; i < n; i++) {
            newA[i] = Math.max(A[0][1], A[1][i]);
        }

        int[][] dp = new int[2][n];

        dp[0][0] = 0;
        dp[1][0] = newA[0];
//        System.out.println(dp[0][0] + "--" + dp[1][0]);
        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
            dp[1][i] = dp[0][i - 1] + newA[i];
//            System.out.println(dp[0][i] + "--" + dp[1][i]);
        }

        return Math.max(dp[0][n - 1], dp[1][n - 1]);

    }
}
