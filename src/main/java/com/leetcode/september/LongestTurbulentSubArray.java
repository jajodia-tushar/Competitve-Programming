package com.leetcode.september;

/*
Given an integer array arr, return the length of a maximum size turbulent subarray of arr.

A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.

More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:

For i <= k < j:
arr[k] > arr[k + 1] when k is odd, and
arr[k] < arr[k + 1] when k is even.
Or, for i <= k < j:
arr[k] > arr[k + 1] when k is even, and
arr[k] < arr[k + 1] when k is odd.


Example 1:

Input: arr = [9,4,2,10,7,8,8,1,9]
Output: 5
Explanation: arr[1] > arr[2] < arr[3] > arr[4] < arr[5]
Example 2:

Input: arr = [4,8,12,16]
Output: 2
Example 3:

Input: arr = [100]
Output: 1


Constraints:

1 <= arr.length <= 4 * 104
0 <= arr[i] <= 109
 */
public class LongestTurbulentSubArray {

    public static void main(String[] args) {

        LongestTurbulentSubArray obj = new LongestTurbulentSubArray();
        int[] arr = {37,199,60,296,257,248,115,31,273,176};
//        int[] arr = {9,4,2,10,7,8,8,1,9};
        int result = obj.maxTurbulenceSize(arr);
        System.out.println(result);

    }

    public int maxTurbulenceSize(int[] arr) {

        int n = arr.length;
        if (n == 1) return 1;

        if (n == 2) {
            if (arr[0] == arr[1]) return 1;
            else return 2;
        }


        int max = 0;

        int start = 0;
        int end = 0;

        // 37,199,60,296,257,248,115,31,273,176
        // 37,199,60,296,257,248,115,31,273,176
        while (end < n - 1) {

            if (end % 2 == 0) {
                if (arr[end] <= arr[end + 1]) {
                    int len = end - start;
                    start = end + 1;
                    max = Math.max(max, len);
                }
            } else {
                if (arr[end] >= arr[end + 1]) {
                    int len = end - start + 1;
                    start = end + 1;
                    max = Math.max(max, len);
                }
            }
            end++;
        }

        max = Math.max(max, end - start);

        start = 0;
        end = 0;

        while (end < n - 1) {

            if (end % 2 == 0) {
                if (arr[end] >= arr[end + 1]) {
                    int len = end - start;
                    start = end + 1;
                    max = Math.max(max, len);
                }
            } else {
                if (arr[end] <= arr[end + 1]) {
                    int len = end - start + 1;
                    start = end + 1;
                    max = Math.max(max, len);
                }
            }
            end++;
        }
        max = Math.max(max, end - start);
        return max;
    }
}
