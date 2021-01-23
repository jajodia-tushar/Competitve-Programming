package com.october.week11;

import java.util.*;

public class Tuesday {


    public static void main(String[] args) {

        Tuesday tuesday = new Tuesday();
        int[] a = {3, 2, 1};
        System.out.println(tuesday.solve(a));

    }

    /*
    Problem Description
        Given an array A containing N integers.
        You need to find the maximum sum of triplet ( Ai + Aj + Ak ) such that 0 <= i < j < k < N and Ai < Aj < Ak.
        If no such triplet exist return 0.



     */


    public int solve(int[] A){

        int n = A.length;
        int suffixArray[] = new int[n];
        suffixArray[n - 1] = A[n - 1];

        for(int i =  n - 2; i >= 0; i --){
            suffixArray[i] = Math.max(A[i],suffixArray[i+1]);
        }

        TreeSet<Integer> prefixList = new TreeSet<>();
        prefixList.lower(10);
        prefixList.add(A[0]);
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i < (n - 1); i++){
            if(suffixArray[i + 1] > A[i]){
                int lowest = getLowest(prefixList, A[i]);
                if(lowest != -1){
                    ans = Math.max(ans, lowest + A[i] + suffixArray[i + 1]);
                }
            }
            prefixList.add(A[i]);
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }

    private int getLowest(TreeSet<Integer> prefixList, int number) {
        Integer lower = prefixList.lower(number);
        return lower == null ? -1 : lower;
    }
}
