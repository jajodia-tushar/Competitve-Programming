package com.interviewbit.dp.matrixandgrid;

public class DungeonPrincess {

    public static void main(String[] args) {

        DungeonPrincess obj = new DungeonPrincess();
        int[][] ints = {{-5, -4, -1}, {-3, 2, 4}, {2, 5, 8}};
        int result = obj.calculateMinimumHP(ints);
        System.out.println(result);
    }

    public int calculateMinimumHP(int[][] A) {

        int row = A.length;
        int col = A[0].length;

        int[][] dp = new int[row][col];


        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {

                if (i == row - 1 && j == col - 1) {
                    dp[i][j] = Math.min(0, A[i][j]);
                } else if (i == row - 1) {
                    dp[i][j] = Math.min(0, dp[i][j + 1] + A[i][j]);
                } else if (j == col - 1) {
                    dp[i][j] = Math.min(0, dp[i + 1][j] + A[i][j]);
                } else {
                    dp[i][j] = Math.min(0, A[i][j] + Math.max(dp[i + 1][j], dp[i][j + 1]));
                }
            }
        }

        return Math.abs(dp[0][0]) + 1;
    }
}
