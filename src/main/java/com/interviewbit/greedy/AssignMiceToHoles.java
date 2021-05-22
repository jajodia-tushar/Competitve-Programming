package com.interviewbit.greedy;

import java.util.Arrays;

public class AssignMiceToHoles {

    public static void main(String[] args) {
        AssignMiceToHoles obj = new AssignMiceToHoles();
        int[] A = {4, -4, 2};
        int[] B = {4, 0, 5};
        int result = obj.mice(A, B);
        System.out.println(result);
    }

    public int mice(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int n = A.length;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, Math.abs(A[i] - B[i]));
        }

        return max;
    }
}
