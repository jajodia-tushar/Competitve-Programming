package com.interviewbit.twopointer;

import java.util.Arrays;
import java.util.List;

/*

Remove Duplicates from Sorted Array

Given a sorted array, remove the duplicates in place such that each element can appear at most twice and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

Note that even though we want you to return the new length, make sure to change the original array as well in place

For example,

Given input array A = [1,1,1,2],

Your function should return length = 3, and A is now [1,1,2].
 */
// YOU MIGHT NEED TO VISIT THIS CHECKAGAIN
public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {

        List integers = Arrays.asList(1,1,1,1,2);
        RemoveDuplicatesFromSortedArrayII obj = new RemoveDuplicatesFromSortedArrayII();
        System.out.println(obj.removeDuplicates(integers));
        System.out.println(integers);
    }

    public int removeDuplicates(List<Integer> a) {

        int i = 0;
        int j = 2;
        int n = a.size();

        if (n < 3) return n;

        while (j < n) {
            if (a.get(j - 2).equals(a.get(j - 1)) && a.get(j - 1).equals(a.get(j))) {
                j++;
            } else {
                a.set(i, a.get(j - 2));
                i++;
                j++;
            }

            if (j == n) {
                a.set(i++, a.get(j - 2));
                a.set(i, a.get(j - 1));
            }
        }
        return i + 1;
    }
}
/*
    Similar to the one done previously.
 */