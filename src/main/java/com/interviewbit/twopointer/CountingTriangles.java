package com.interviewbit.twopointer;

import com.interviewbit.utils.ArrayUtils;

import java.util.Arrays;

/*
You are given an array of N non-negative integers, A0, A1 ,…, AN-1.
Considering each array element Ai as the edge length of some line segment, count the number of triangles which you can form using these array values.

Notes:

You can use any value only once while forming each triangle. Order of choosing the edge lengths doesn’t matter. Any triangle formed should have a positive area.

Return answer modulo 109 + 7.

For example,

A = [1, 1, 1, 2, 2]

Return: 4
 */
public class CountingTriangles {

    public static void main(String[] args) {
        CountingTriangles obj = new CountingTriangles();
        System.out.println(obj.nTriang(ArrayUtils.asArrays(4, 6, 13, 16, 20, 3, 1, 12)));
    }

    public int nTriang(int[] A) {
        Arrays.sort(A);
        int count = 0;

        for (int i = A.length - 1; i > 0; i--) {
            int j = 0;
            int k = i - 1;
            while (j < k) {
                if ((A[j] + A[k]) > A[i]) {
                    count += (k - j);
                    k--;
                } else {
                    j++;
                }
            }
        }

        return count;

    }

    static int findNumberOfTriangles(int arr[], int n) {
        // Count of triangles
        int count = 0;

        // The three loops select three
        // different values from array
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                // The innermost loop checks for
                // the triangle property
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] > arr[k]
                            && arr[i] + arr[k] > arr[j]
                            && arr[k] + arr[j] > arr[i]) {
                        count++;
                        System.out.println("(" + arr[i] + " " + arr[j] + " " + arr[k] + ")");
                    }
                }

                // Sum of two sides is greater
                // than the third
            }
        }
        return count;
    }

    /*
    (3 4 6) -
(3 12 13) -
(4 12 13) -
(4 13 16) -
(6 12 13) -
(6 12 16) -
(6 13 16) -
(6 16 20) -
(12 13 16) -
(12 13 20) -
(13 16 20) -
     */

    // Driver code
//    public static void main(String[] args) {
//        int arr[] = {4, 6, 13, 16, 20, 3, 1, 12};
//        int size = arr.length;
//
//        System.out.println("Total number of triangles possible is " +
//                findNumberOfTriangles(arr, size));
//    }
}

/*
    The technique is to sort the array so that you don't have to tech the three conditions for
    verifying if it is array or not.
    You can verify in one shot.
    Now the way of counting is also amazing.
    If you fix i = 0 and k = n; j = n - 1;

    and if A[i] + A[j] > A[k]
        count += j - i
        because see current array value of i pair with j to form the triangle
        so all the values from i + 1 to j will also pair right ?
        logical.

 */
