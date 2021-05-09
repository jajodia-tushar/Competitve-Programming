package com.interviewbit.dp.dptricky;

import com.interviewbit.utils.ArrayUtils;

public class KthManhattanDistanceNeighbourhood {

    public static void main(String[] args) {

        KthManhattanDistanceNeighbourhood obj = new KthManhattanDistanceNeighbourhood();
        int[][] ints = {{1, 2, 4}, {4, 5, 8}};
        int[][] result = obj.solve(2, ints);
        ArrayUtils.printArray(result);
    }

    public int[][] solve(int A, int[][] B) {

        int row = B.length;
        int col = B[0].length;

        if (A == 0) return B;

        int[][] dp = new int[row][col];

        for (int k = 0; k < A; k++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int left = j - 1 >= 0 ? B[i][j - 1] : Integer.MIN_VALUE;
                    int right = j + 1 < col ? B[i][j + 1] : Integer.MIN_VALUE;
                    int up = i - 1 >= 0 ? B[i - 1][j] : Integer.MIN_VALUE;
                    int down = i + 1 < row ? B[i + 1][j] : Integer.MIN_VALUE;
                    dp[i][j] = Math.max(B[i][j],
                            Math.max(Math.max(left, right), Math.max(up, down)));
                    // System.out.println(dp[i][j]);
                }
            }
            int[][] temp = B;
            B = dp;
            dp = temp;
        }
        return B;
    }
}
