package com.october.week11;

import java.util.*;

public class Tuesday {


    public static void main(String[] args) {

        Tuesday tuesday = new Tuesday();
        int[] a = { 18468, 6335, 26501, 19170, 15725, 11479, 29359, 26963, 24465, 5706, 28146, 23282, 16828, 9962, 492, 2996, 11943, 4828, 5437, 32392, 14605};
//        System.out.println(tuesday.solve(a));
        System.out.println(tuesday.solveAgain(a));

    }

    /*
    Problem Description
        Given an array A containing N integers.
        You need to find the maximum sum of triplet ( Ai + Aj + Ak ) such that 0 <= i < j < k < N and Ai < Aj < Ak.
        If no such triplet exist return 0.



     */


    public int solve(int[] A) {

        int n = A.length;
        int suffixArray[] = new int[n];
        suffixArray[n - 1] = A[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixArray[i] = Math.max(A[i], suffixArray[i + 1]);
        }

        TreeSet<Integer> prefixList = new TreeSet<>();
        prefixList.lower(10);
        prefixList.add(A[0]);
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < (n - 1); i++) {
            if (suffixArray[i + 1] > A[i]) {
                int lowest = getLowest(prefixList, A[i]);
                if (lowest != -1) {
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


    public int solveAgain(int[] A) {

        int n = A.length;
        int[] suffix = new int[n];

        suffix[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] > suffix[i + 1]) {
                suffix[i] = A[i];
            } else {
                suffix[i] = suffix[i + 1];
            }
        }

        //  TreeSet<Integer> treeSet = new TreeSet();
        //  treeSet.add(A[0]);
        int ans = Integer.MIN_VALUE;
        int arr[] = new int[n];
        arr[0] = A[0];

        for (int i = 1; i < n - 1; i++) {
            int high = suffix[i + 1];

            if (high > A[i]) {
                // Integer lower = treeSet.lower(A[i]);
                int lower = greatestLesser(arr, A[i], 0, i);
                if (lower != -1) {
                    ans = Math.max(ans, (lower + A[i] + high));
                }
            }
            arr[i] = A[i];
            // treeSet.add(A[i]);
        }

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }


    public int greatestLesser(int[] A, int num, int lower, int higher) {
//        int[] A = Arrays.copyOf(B, higher);
        Arrays.sort(A,lower,higher--);

        int mid = lower + (higher - lower) / 2;
        int ans = -1;

        while (higher >= lower) {
            mid = lower + (higher - lower) / 2;

            if (A[mid] > num) {
                higher = mid - 1;
            } else if (A[mid] < num) {
                lower = mid + 1;
                ans = A[mid];
            } else {
                higher = mid - 1;
            }
        }
        return ans;
    }

}
