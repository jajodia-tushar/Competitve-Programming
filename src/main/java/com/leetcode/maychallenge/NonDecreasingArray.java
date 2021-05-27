package com.leetcode.maychallenge;

import com.interviewbit.utils.ArrayUtils;

public class NonDecreasingArray {


    public static void main(String[] args) {

        RunningSumOfArray obj = new RunningSumOfArray();
        int[] ints = {1, 2, 3, 4};
        boolean result = obj.checkPossibility(ints);
        System.out.println(result);
    }

    public boolean checkPossibility(int[] nums) {

        int n = nums.length;
        int pre = Integer.MIN_VALUE;
        boolean possible = true;
        for (int i = 0; i < n - 1; i++) {
            int curr = nums[i];
            int next = nums[i + 1];
            if (next < curr) {
                if (possible) possible = false;
                else return false;
                if (next < pre) nums[i + 1] = curr;
                else nums[i] = next;
            }
            pre = nums[i];
        }
        return true;
    }
}
