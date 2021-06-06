package com.interviewbit.arrays;


import com.interviewbit.utils.ArrayUtils;

/*
Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.
Input Format:
The first and the only argument contains an integer, A.
Output Format:

Return a 2-d matrix of size A x A satisfying the spiral order.
Constraints:

1 <= A <= 1000
Examples:

Input 1:
    A = 3

Output 1:
    [   [ 1, 2, 3 ],
        [ 8, 9, 4 ],
        [ 7, 6, 5 ]   ]

Input 2:
    4

Output 2:
    [   [1, 2, 3, 4],
        [12, 13, 14, 5],
        [11, 16, 15, 6],
        [10, 9, 8, 7]   ]
 */
public class SpiralOrderMatrixII {

    public static void main(String[] args) {
        SpiralOrderMatrixII obj = new SpiralOrderMatrixII();
        int[][] ints = obj.generateMatrix(5);
        ArrayUtils.printArray(ints);
    }

    public int[][] generateMatrix(int A) {
        int[][] result = new int[A][A];

        int[] rowPosition = {0, 1, 0, -1};
        int[] columnPosition = {1, 0, -1, 0};

        int max = A * A;
        int current = 0;
        int currentX = 0;
        int currentY = -1;
        int j = 0;

        while (current < max) {
            for (int i = 0; i < 4; i++) {
                int xPosition = rowPosition[i];
                int yPosition = columnPosition[i];
                while (true) {
                    currentX += xPosition;
                    currentY += yPosition;
                    if (currentX < 0 || currentX > A - 1 || currentY < 0 || currentY > A - 1 || result[currentX][currentY] != 0) {
                        currentX -= xPosition;
                        currentY -= yPosition;
                        break;
                    }
                    result[currentX][currentY] = ++current;
                }
            }
        }
        return result;
    }

    public int[][] generateMatrixIntuitive(int n) {
        int a[][] = new int[n][n];
        int top = 0;
        int left = 0;
        int right = n - 1;
        int bottom = n - 1;
        int c = 1;
        while (c <= n * n) {
            for (int i = top; i <= right; i++) {
                a[top][i] = c;
                c++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                a[i][right] = c;
                c++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                a[bottom][i] = c;
                c++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                a[i][left] = c;
                c++;
            }
            left++;
        }
        return a;
    }
}
/*
    There is nothing much in this question as well.
    Just Look Around and you will be able to grasp.
    The second one is more intuitive
    but the first one is little easy


 */
