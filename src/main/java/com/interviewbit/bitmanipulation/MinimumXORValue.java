package com.interviewbit.bitmanipulation;

import java.util.Arrays;

/*
    find the min xor value of a pair.

 */

public class MinimumXORValue {

    public static void main(String[] args) {

        MinimumXORValue obj = new MinimumXORValue();
        System.out.println(obj.findMinXor(new int[]{0, 4, 7, 9}));
    }


    public int findMinXor(int[] A) {
        Arrays.sort(A);
        int min_xor = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            int xor = A[i] ^ A[i + 1];
            if (xor < min_xor)
                min_xor = xor;
        }

        return min_xor;
    }
}

/*
    There is nothing after sorting.
 */