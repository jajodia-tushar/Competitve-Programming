package com.interviewbit.hashing;

import com.interviewbit.utils.ArrayUtils;

import java.util.HashMap;
import java.util.HashSet;

/*
Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

Example :

Input :

A : [1 5 3]
k : 2
Output :

1
as 3 - 1 = 2

Return 0 / 1 for this problem.
 */
public class DiffII {

    public static void main(String[] args) {

        DiffII obj = new DiffII();
        int[] ints = ArrayUtils.asArrays(1, 5, 3);
        System.out.println(obj.diffPossible(ints, 2));


    }

    public int diffPossible(final int[] A, int B) {

        int n = A.length;

        if (n < 2) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(A[i], i);
        }

        for (int i = 0; i < n; i++) {
            int diff = B + A[i];
            if (map.containsKey(diff) && (map.get(diff) != i)) {
                return 1;
            }
        }

        return 0;
    }

    public int diffPossibleEfficient(final int[] A, int B) {

        int n = A.length;
        HashSet<Integer> visitedSet = new HashSet<>();
        for (int value : A) {
            if (visitedSet.contains(B - value) || visitedSet.contains(B + value)) return 1;
            visitedSet.add(value);
        }
        return 0;
    }
}

/*
    There is nothing.
    See you have two chances for a required sum to be discovered. At I and At J.
    So you explore two both chances.
    A[i] - B and A[i] + B.

    Easy Right.
 */
