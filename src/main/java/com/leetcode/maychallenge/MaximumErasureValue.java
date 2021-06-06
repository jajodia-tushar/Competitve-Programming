package com.leetcode.maychallenge;


/*

You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.
Return the maximum score you can get by erasing exactly one subarray.
An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).

 */

import com.interviewbit.utils.ArrayUtils;

import java.util.*;

public class MaximumErasureValue {

    public static void main(String[] args) {
        MaximumErasureValue obj = new MaximumErasureValue();
        int result = obj.maximumUniqueSubarray(ArrayUtils.asArrays(5, 2, 1, 2, 5, 2, 1, 2, 5));
        System.out.println(result);
    }

    public int maximumUniqueSubarray(int[] nums) {

        int n = nums.length;
        Set<Integer> sets = new HashSet<>();

        int sumTillNow = 0;
        int maxSum = Integer.MIN_VALUE;

        int leftPointer = 0;

        for (int i = 0; i < n; i++) {
            int currentNumber = nums[i];
            sumTillNow += currentNumber;


            if (sets.contains(currentNumber)) {
                while (leftPointer < i) {
                    int num = nums[leftPointer];
                    sumTillNow -= num;
                    leftPointer++;
                    sets.remove(num);
                    if (num == currentNumber) {
                        break;
                    }
                }
            }
            // System.out.println(i+" ---> "+sumTillNow);
            maxSum = Math.max(maxSum, sumTillNow);
            sets.add(currentNumber);
        }

        return maxSum;
    }


}
