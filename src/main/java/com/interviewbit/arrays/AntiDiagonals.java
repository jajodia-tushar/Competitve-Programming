package com.interviewbit.arrays;

import com.interviewbit.utils.ArrayUtils;

/*
Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.

Example:
Input:

1 2 3
4 5 6
7 8 9

Return the following :

[
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]


Input :
1 2
3 4

Return the following  :

[
  [1],
  [2, 3],
  [4]
]

 */
public class AntiDiagonals {

    public static void main(String[] args) {

        AntiDiagonals obj = new AntiDiagonals();
        int[][] ints = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] result = obj.diagonal(ints);

        ArrayUtils.printArray(ints);
        System.out.println();
        ArrayUtils.printArray(result);
    }

    public int[][] diagonal(int[][] arr) {

        int rows = arr.length;
        int n = 2 * rows - 1;
        int[][] result = new int[n][];

        for (int i = 0; i < n; i++) {
            int size = i + 1;
            if (i >= rows) {
                size = rows - (size % rows);
            }
            result[i] = new int[size];
        }

        for (int i = 0; i < rows; i++) {
            int column = i;
            int resultInnerIndex = 0;
            for (int row = 0; column >= 0; row++, column--, resultInnerIndex++) {
                result[i][resultInnerIndex] = arr[row][column];
            }
        }

        int resultIndex = rows;
        for (int i = 1; i < rows; i++) {
            int column = rows - 1;
            int resultInnerIndex = 0;
            for (int row = i; resultInnerIndex < result[resultIndex].length; row++, column--, resultInnerIndex++) {
                result[resultIndex][resultInnerIndex] = arr[row][column];
            }
            resultIndex++;
        }


        return result;
    }
}

/*
    There is no logic in this program.
    Just one thing to notice is values are requested in the form of
    row++ and col--
 */
