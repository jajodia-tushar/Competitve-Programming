package com.interviewbit.graph;

import com.interviewbit.utils.ArrayUtils;

public class FloydWarshallAlgorithm {

    public static void main(String[] args) {

        FloydWarshallAlgorithm obj = new FloydWarshallAlgorithm();
        int[][] ints = {{0, 3, 9999, 7}, {8, 0, 2, 9999}, {5, 9999, 0, 1}, {2, 9999, 9999, 0}};
        int[][] result = obj.solve(ints);
        ArrayUtils.printArray(result);
    }

    public int[][] solve(int[][] ints) {
        int row = ints.length;
        int col = ints[0].length;

        int[][] dp = new int[row][col];

        for (int k = 0; k < row; k++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    dp[i][j] = Math.min(ints[i][j], ints[i][k] + ints[k][j]);
                }
            }
            ints = dp;
        }
        return dp;
    }
}
