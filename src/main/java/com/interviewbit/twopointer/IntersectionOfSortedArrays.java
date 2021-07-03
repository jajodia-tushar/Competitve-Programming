package com.interviewbit.twopointer;

import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;

/*
Find the intersection of two sorted arrays.
OR in other words,
Given 2 sorted arrays, find all the elements which occur in both the arrays.

Example :

Input :
    A : [1 2 3 3 4 5 6]
    B : [3 3 5]

Output : [3 3 5]

Input :
    A : [1 2 3 3 4 5 6]
    B : [3 5]

Output : [3 5]
 NOTE : For the purpose of this problem ( as also conveyed by the sample case ), assume that elements that appear more than once in both arrays should be included multiple times in the final output.
 */
public class IntersectionOfSortedArrays {

    public static void main(String[] args) {
        int[] a = ArrayUtils.asArrays(1, 2, 3, 3, 4, 5, 6);
        int[] b = ArrayUtils.asArrays(3, 3, 5);
        IntersectionOfSortedArrays obj = new IntersectionOfSortedArrays();
        int[] intersect = obj.intersect(a, b);
        ArrayUtils.printArray(intersect);
    }

    public int[] intersect(final int[] A, final int[] B) {

        int i = 0;
        int j = 0;

        ArrayList<Integer> arr = new ArrayList<>();

        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) {
                arr.add(A[i]);
                i++;
                j++;
            } else if (A[i] < B[j]) {
                i++;
            } else {
                j++;
            }
        }

        return arr.stream().mapToInt(x -> x).toArray();
    }
}

/*
    There is nothing Much in this question really.
    Look at the code it is similar to Binary Search.
 */