package com.interviewbit.dp.matrixandgrid;

import java.util.HashMap;

public class SubMatricesWithSumZero {

    public static void main(String[] args) {
        SubMatricesWithSumZero obj = new SubMatricesWithSumZero();
        int[][] matrix = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        int solve = obj.solve(matrix);
        System.out.println(solve);
    }

    public int solve(int[][] matrix) {

        int rows = matrix.length;
        if (rows == 0) return 0;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                matrix[i][j] = matrix[i][j] + matrix[i][j - 1];
            }
        }
        int target = 4;
        int count = 0;
        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int col1 = 0; col1 < columns; col1++) {
            for (int col2 = col1; col2 < columns; col2++) {
                maps.clear();
                maps.put(0, 1);
                int sum = 0;
                for (int row = 0; row < rows; row++) {
                    sum += matrix[row][col2];
                    if (col1 > 0) {
                        sum -= matrix[row][col1 - 1];
                    }
                    count += maps.getOrDefault(sum - target, 0);
                    maps.put(sum, maps.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return count;
    }
}
