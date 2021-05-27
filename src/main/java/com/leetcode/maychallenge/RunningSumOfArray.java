package com.leetcode.maychallenge;

import com.interviewbit.utils.ArrayUtils;

public class RunningSumOfArray {

    public static void main(String[] args) {

        RunningSumOfArray obj = new RunningSumOfArray();
        int[] ints = {1, 2, 3, 4};
        int[] result = obj.runningSum(ints);
        ArrayUtils.printArray(result);
    }

    public int[] runningSum(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];
        result[0] = nums[0];

        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] + nums[i];
        }

        return result;

    }
}
