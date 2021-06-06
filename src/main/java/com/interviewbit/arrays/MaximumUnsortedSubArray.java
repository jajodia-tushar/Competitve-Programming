package com.interviewbit.arrays;

import com.interviewbit.utils.ArrayUtils;
import com.sun.nio.sctp.PeerAddressChangeNotification;

/*
You are given an array (zero indexed) of N non-negative integers, A0, A1 ,…, AN-1.
Find the minimum sub array Al, Al+1 ,…, Ar so if we sort(in ascending order) that sub array, then the whole array should get sorted.
If A is already sorted, output -1.

Example :
Input 1:
A = [1, 3, 2, 4, 5]
Return: [1, 2]

Input 2:
A = [1, 2, 3, 4, 5]
Return: [-1]
In the above example(Input 1), if we sort the subArray A1, A2, then whole array A should get sorted.
 */
public class MaximumUnsortedSubArray {

    public static void main(String[] args) {

        MaximumUnsortedSubArray obj = new MaximumUnsortedSubArray();
        int[] ints = {1, 1, 10, 10, 15, 10, 15, 10, 10, 15, 10, 15};
        int[] result = obj.subUnSort(ints);
        ArrayUtils.printArray(result);
    }

    public int[] subUnSort(int[] A) {
        int n = A.length;
        int start = -1;
        int end = -1;

        for (int i = 1; i < n; i++) {
            if (A[i - 1] > A[i]) {
                start = i - 1;
                break;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (A[i + 1] < A[i]) {
                end = i + 1;
                break;
            }
        }

        if (start == end) {
            return new int[]{-1};
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = start; i <= end; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }

        for (int i = 0; i <= start; i++) {
            if (A[i] > min) {
                start = i;
                break;
            }
        }

        for (int i = n - 1; i >= end; i--) {
            if (A[i] < max) {
                end = i;
                break;
            }
        }
        return new int[]{start, end};
    }
}

/*

    This question seems easy but it's not really that easy.
    Sort the array and find the first and the last item which
    has changed the index but before that you will need to store index as
    well of every item.

    But this is not a good approach.
    The better Idea is what I have shown in the above code.
    You iterate from the starting and check

    A[i - 1] > A[i] ---> Is previous Number greater than Current.
    You get first Number violating the sorting principle

    You iterate from ending and check
    A[i + 1] < A[i] ---> Is next Number smaller than current Number
    You get the last Number violating the sorting principle

    But it doesn't end here either.

    You can have something like
    1 2 3 4 5 10 20 30 3 50 40 100

    You will get 30 as the first number [30 > 3 is true]

    Similarly You will get 40 as last Number [40 < 50 is true]

    Now you just can't return [30,3,50,40]
    Because sorting this sub array will not sort the complete array.

    So You will need to search in this possible sub-array to find the min and max.

    And you will need to see on your left of this sub-array if there is any
    number which is greater than min [ Because sorting will cause this min number to take the place of
    the first number which is greater than this number.

    Similarly you will need to search on right of your sub-array if there is any
    number which is smaller than the max [ Because sorting will cause this max number to take the place of
    the first number which is smaller from end]

    You are now done.


 */