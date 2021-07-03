package com.interviewbit.twopointer;

public class MaxContinuousSeriesOf1s {

    public static void main(String[] args) {

    }

    public int[] maxone(int[] A, int B) {

        int i = 0;
        int j = 0;
        int max = 0;
        int start = 0;
        int zeroCount = 0;
        while (j < A.length) {

            if (zeroCount <= B) {
                if (A[j] == 0)
                    zeroCount++;
                j++;
            }

            if (zeroCount > B) {
                if (A[i] == 0)
                    zeroCount--;
                i++;
            }

            if (((j - i) > max) && (zeroCount <= B)) {
                max = j - i;
                start = i;
            }
        }

        int[] arr = new int[max];
        for (i = 0; i < arr.length; i++) {
            arr[i] = start;
            start++;
        }

        return arr;

    }

    public int solve(int[] A, int B) {

        int start = 0;
        int end = 0;
        int n = A.length;
        int maxSum = Integer.MIN_VALUE;
        int currValue = 0;
        int currB = 0;

        while (end < n) {
            if (A[end] == 1) {
                currValue++;
                maxSum = Math.max(maxSum, currValue);
            } else {
                currB++;
                if (B < currB) {
                    while (B < currB && start <= end) {
                        if (A[start] == 0) currB--;
                        else currValue--;
                        start++;
                    }
                }
            }
            end++;
        }
        return Math.min(maxSum + B, n);
    }
}
