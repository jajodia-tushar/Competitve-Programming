package com.interviewbit.dp.matrixandgrid;

import javax.lang.model.type.UnionType;

public class UniquePathsInAGrid {

    public static void main(String[] args) {

        UniquePathsInAGrid obj = new UniquePathsInAGrid();
        int[][] ints = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int result = obj.uniquePathsWithObstacles(ints);
        System.out.println(result);

    }

    public int uniquePathsWithObstacles(int[][] A) {

        int row = A.length;
        int col = A[0].length;

        int[][] dp = new int[row][col];


        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {

                if (A[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (i == row - 1 && j == col - 1) {
                    dp[i][j] = 1;
                } else if (i == row - 1) {
                    dp[i][j] = dp[i][j + 1];
                } else if (j == col - 1) {
                    dp[i][j] = dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }
}
