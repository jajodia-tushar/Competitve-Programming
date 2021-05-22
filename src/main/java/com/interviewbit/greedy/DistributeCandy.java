package com.interviewbit.greedy;

import java.util.Arrays;

// Simple But Quite Interesting Question.
public class DistributeCandy {

    public static void main(String[] args) {

        DistributeCandy obj = new DistributeCandy();
        int[] ints = {1, 5, 2, 1};
        int result = obj.candy(ints);
        System.out.println(result);

    }

    public int candy(int[] A) {

        int n = A.length;

        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 1; i < n; i++) {

            if (A[i] > A[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += Math.max(left[i], right[i]);
        }

        return count;

    }
}
