package com.interviewbit.binarysearch;

/*
Given a matrix of integers A of size N x M and an integer B.

Write an efficient algorithm that searches for integar B in matrix A.

This matrix A has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.




Input Format

The first argument given is the integer matrix A.
The second argument given is the integer B.
Output Format

Return 1 if B is present in A, else return 0.
Constraints

1 <= N, M <= 1000
1 <= A[i][j], B <= 10^6
For Example

Input 1:
    A =
    [ [1,   3,  5,  7],
      [10, 11, 16, 20],
      [23, 30, 34, 50]  ]
    B = 3
Output 1:
    1

Input 2:
    A = [   [5, 17, 100, 111]
            [119, 120,  127,   131]    ]
    B = 3
Output 2:
    0
 */

public class MatrixSearch {

    public static void main(String[] args) {
        int arr[][] = {{1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};

        MatrixSearch obj = new MatrixSearch();
        System.out.println(obj.searchMatrixX(arr, 3));
    }

    public int searchMatrix(int[][] A, int B) {

        int n = A.length;
        int m = A[0].length;

        int low = 0;
        int high = n * m - 1;

        while (high >= low) {
            int mid = (high + low) / 2;

            int midI = mid / m;
            int midJ = mid % m;

            int midItem = A[midI][midJ];


            if (midItem > B) {
                high = mid - 1;
            } else if (midItem < B) {
                low = mid + 1;
            } else {
                return 1;
            }
        }
        return 0;
    }

    public int searchMatrixX(int[][] A, int B) {

        int row = A.length;
        int col = A[0].length;

        int start = 0;
        int end = row * col;


        while (start <= end) {
            int mid = start + (end - start) / 2;

            int xRow = (mid - 1) / col;
            int xCol = (mid - 1) % col;

            System.out.println(start + " -- " + end + " -- " + mid + " -- " + xRow + " -- " + xCol);

            if (A[xRow][xCol] > B) {
                end = mid - 1;
            } else if (A[xRow][xCol] < B) {
                start = mid + 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}

/*
    Read the question properly it saws that the end of the nth row is smaller than the
    first of n + 1th Row.

    This is now easy.
    Just use basic Binary Search but the catch is just to find a number at particular location.
    Think and You can do it.

 */
