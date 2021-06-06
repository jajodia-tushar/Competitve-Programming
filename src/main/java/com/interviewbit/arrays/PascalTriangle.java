package com.interviewbit.arrays;

import com.interviewbit.utils.ArrayUtils;

/*
Given numRows, generate the first numRows of Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]
 */
public class PascalTriangle {

    public static void main(String[] args) {

        PascalTriangle obj = new PascalTriangle();
        int[][] result = obj.solve(5);
        ArrayUtils.printArray(result);
    }

    public int[][] solve(int A) {

        int[][] result = new int[A][];
        A--;

        for (int i = 0; i <= A; i++) {
            result[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                if (i == 0 || j == 0) {
                    result[i][j] = 1;
                } else if (i == j) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
                }
            }
        }
        return result;
    }


}
