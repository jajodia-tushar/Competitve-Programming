package com.october.week20;

import java.util.Arrays;

public class NobelInteger {

    /*

    Problem Description
    Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p.

     */

    public static void main(String[] args) {

    }

    public int solve(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        for(int i = 0; i < n -1; i++){
            if(A[i] == A[i+1])
                continue;

            int numberRemaining = n - i - 1;
            if(numberRemaining == A[i])
                return 1;
        }

        if(A[n - 1] == 0){
            return 1;
        }

        return -1;

    }
}
