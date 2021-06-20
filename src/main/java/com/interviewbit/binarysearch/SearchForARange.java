package com.interviewbit.binarysearch;

import com.interviewbit.utils.ArrayUtils;

/*
Given a sorted array of integers A(0 based index) of size N, find the starting and ending position of a given integar B in array A.

Your algorithm’s runtime complexity must be in the order of O(log n).

Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].




Input Format

The first argument given is the integer array A.
The second argument given is the integer B.
Output Format

 Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].
Constraints

1 <= N <= 10^6
1 <= A[i], B <= 10^9
For Example

Input 1:
    A = [5, 7, 7, 8, 8, 10]
    B = 8
Output 1:
    [3, 4]
Explanation 1:
    First occurence of 8 in A is at index 3
    Second occurence of 8 in A is at index 4
    ans = [3, 4]

Input 2:
    A = [5, 17, 100, 111]
    B = 3
Output 2:
    [-1, -1]
 */

public class SearchForARange {

    public static void main(String[] args) {
        int[] A = {5, 7, 7, 8, 8, 10};
        int B = 8;
        SearchForARange obj = new SearchForARange();
        int[] result = obj.searchRange(A, B);
        ArrayUtils.printArray(result);
    }

    public int[] searchRange(final int[] A, int B) {

        int[] result = new int[2];
        result[0] = goLeft(A, B);
        result[1] = goRight(A, B);

        return result;

    }

    public int goRight(int[] A, int B) {

        int n = A.length;
        int low = 0;
        int high = n - 1;
        int result = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;
            int midItem = A[mid];

            if (midItem > B) {
                high = mid - 1;
            } else if (midItem < B) {
                low = mid + 1;
            } else {
                result = mid;
                low = mid + 1;
            }
        }
        return result;
    }


    public int goLeft(int[] A, int B) {

        int n = A.length;
        int low = 0;
        int high = n - 1;
        int result = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;
            int midItem = A[mid];

            if (midItem > B) {
                high = mid - 1;
            } else if (midItem < B) {
                low = mid + 1;
            } else {
                result = mid;
                high = mid - 1;
            }
        }
        return result;
    }
}

/*
    There is nothing in this question.

 */