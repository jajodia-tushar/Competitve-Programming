package com.interviewbit.greedy;

public class HighestProduct {

    public static void main(String[] args) {
        HighestProduct obj = new HighestProduct();
        int[] arr = {0, -1, 3, 100, 70, 50};
        int result = obj.maxp3(arr);
        System.out.println(result);
    }

    public int maxp3(int[] A) {

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        int n = A.length;

        if (n < 3) {
            return 0;
        }

        if (n == 3) {
            return A[0] * A[1] * A[2];
        }

        for (int i = 0; i < n; i++) {

            if (A[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = A[i];
            } else if (A[i] > max2) {
                max3 = max2;
                max2 = A[i];
            } else if (A[i] > max3) {
                max3 = A[i];
            } else if (A[i] < min1) {
                min2 = min1;
                min1 = A[i];
            } else if (A[i] < min2) {
                min2 = A[i];
            }

        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}
