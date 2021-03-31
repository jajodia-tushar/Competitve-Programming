package com.interviewbit.twopointer;

import com.interviewbit.utils.ArrayUtils;

import java.util.Arrays;

public class CountingTriangles {

    public static void main(String[] args) {
        CountingTriangles obj = new CountingTriangles();
        System.out.println(obj.nTriang(ArrayUtils.asArrays(4, 6, 13, 16, 20, 3, 1, 12 )));
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
                            && arr[k] + arr[j] > arr[i]){
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
