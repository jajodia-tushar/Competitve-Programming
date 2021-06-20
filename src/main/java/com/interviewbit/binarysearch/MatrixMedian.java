package com.interviewbit.binarysearch;

/*
Given a matrix of integers A of size N x M in which each row is sorted.
Find an return the overall median of the matrix A.
Note: No extra memory is allowed.
Note: Rows are numbered from top to bottom and columns are numbered from left to right.
Input Format

The first and only argument given is the integer matrix A.
Output Format

Return the overall median of the matrix A.
Constraints

1 <= N, M <= 10^5
1 <= N*M  <= 10^6
1 <= A[i] <= 10^9
N*M is odd
For Example

Input 1:
    A = [   [1, 3, 5],
            [2, 6, 9],
            [3, 6, 9]   ]
Output 1:
    5
Explanation 1:
    A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
    Median is 5. So, we return 5.

Input 2:
    A = [   [5, 17, 100]    ]
Output 2:
    17 ``` Matrix=
 */

public class MatrixMedian {

    public static void main(String[] args) {
        MatrixMedian obj = new MatrixMedian();
        int[][] arr = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}};
        System.out.println(obj.findMedian(arr));
    }

    public int findMedian(int[][] A) {

        int row = A.length;
        int column = A[0].length;
        int req = (row * column + 1) / 2;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < row; i++) {
            min = Math.min(min, A[i][0]);
            max = Math.max(max, A[i][column - 1]);
        }

        while (min < max) {
            int mid = min + (max - min) / 2;
            int place = 0;
            int get = 0;

            for (int i = 0; i < row; ++i) {
                get = binarySearch(A[i], mid);

                // This can be removed and Optimized to just get the number of elements less than the given element.
                while (get < A[i].length && A[i][get] == mid)
                    get += 1;

                place = place + get;
            }
            if (place < req)
                min = mid + 1;
            else
                max = mid;
        }
        return min;
    }

    public int binarySearch(int[] A, int item) {

        int low = 0;
        int high = A.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (A[mid] > item) {
                high = mid - 1;
            } else if (A[mid] < item) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return low;
    }
}

/*
    Not too much serious question once you figure out that for a median point the length of left array and the right array must be equal.
    so the question is just find that point which can be found using binary search.
    For that you can see how many elements are smaller than chosen number in the current array and you can sum for all the array.

    if the value is not equal to required you can choose a next value depending in the Binary search trick.
 */


