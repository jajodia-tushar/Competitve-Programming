package com.lovebabbar;


import java.util.Arrays;

/*
    Given an array arr[] denoting heights of N towers and a positive integer K,
    you have to modify the height of each tower either by increasing or
    decreasing them by K only once. After modifying, height should be
    a non-negative integer. Find out what could be the possible minimum
    difference of the height of shortest and longest towers after you
    have modified each tower.

    Example 1:
    Input:
    K = 2, N = 4
    Arr[] = {1, 5, 8, 10}
    Output:
    5
    Explanation:
    The array can be modified as
    {3, 3, 6, 8}. The difference between
    the largest and the smallest is 8-3 = 5.
 */
public class MinimizeTheMaximumDifferenceBetweenHeights {

    public static void main(String[] args) {

        MinimizeTheMaximumDifferenceBetweenHeights obj = new MinimizeTheMaximumDifferenceBetweenHeights();
        int[] arr = {1, 1, 1, 2, 5, 6, 7, 9, 9, 10};
        int k = 4;

        int result = obj.getMinDiff(arr, k);
        System.out.println(result);
    }


    int getMinDiff(int[] arr, int k) {

        int n = arr.length;
        Arrays.sort(arr);
        int max = 0;
        int min = 0;
        int result = arr[n - 1] - arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] >= k) {

                max = Math.max(arr[i - 1] + k, arr[n - 1] - k);
                min = Math.min(arr[i] - k, arr[0] + k);

                result = Math.min(result, max - min);
            }
        }
        return result;
    }
}
