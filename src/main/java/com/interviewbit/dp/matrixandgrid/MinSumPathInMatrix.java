package com.interviewbit.dp.matrixandgrid;

public class MinSumPathInMatrix {

    public static void main(String[] args) {
        MinSumPathInMatrix obj = new MinSumPathInMatrix();
        int[][] ints = {{-5, -4, -1}, {-3, 2, 4}, {2, 5, 8}};
        int result = obj.minPathSum(ints);
        System.out.println(result);
    }

    public int minPathSum(int[][] A) {

        int row = A.length;
        int col = A[0].length;

        int[][] dp = new int[row][col];


        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {

                if (i == row - 1 && j == col - 1) {
                    dp[i][j] = A[i][j];
                } else if (i == row - 1) {
                    dp[i][j] = A[i][j] + dp[i][j + 1];
                } else if (j == col - 1) {
                    dp[i][j] = A[i][j] + dp[i + 1][j];
                } else {
                    int right = dp[i][j + 1];
                    int down = dp[i + 1][j];
                    dp[i][j] = A[i][j] + Math.min(right, down);
                }
            }
        }

        return dp[0][0];
    }
}
