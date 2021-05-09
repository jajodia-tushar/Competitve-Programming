package com.interviewbit.dp.matrixandgrid;

public class KingdomWar {

    public static void main(String[] args) {
        KingdomWar obj = new KingdomWar();
        int[][] ints = {{-5, -4, -1},{-3, 2, 4},{2, 5, 8}};
        int result = obj.solve(ints);
        System.out.println(result);

    }

    public int solve(int[][] A) {

        int row = A.length;
        int col = A[0].length;

        int[][] dp = new int[row][col];
        int max = Integer.MIN_VALUE;

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {

                if (i == row - 1 && j == col - 1) {
                    dp[i][j] = A[i][j];
                } else if (i == row - 1) {
                    dp[i][j] = A[i][j] + dp[i][j + 1];
                } else if (j == col - 1) {
                    dp[i][j] = A[i][j] + dp[i + 1][j];
                } else {
                    dp[i][j] = A[i][j] + dp[i + 1][j] + dp[i][j + 1] - dp[i + 1][j + 1];
                }

                max = Math.max(max, dp[i][j]);
            }
        }

        return max;

    }
}
