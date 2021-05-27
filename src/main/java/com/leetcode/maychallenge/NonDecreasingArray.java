package com.leetcode.maychallenge;

/*
    Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.

    We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).



    Example 1:

    Input: nums = [4,2,3]
    Output: true
    Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
    Example 2:

    Input: nums = [4,2,1]
    Output: false
    Explanation: You can't get a non-decreasing array by modify at most one element.


    Constraints:

    n == nums.length
    1 <= n <= 104
    -105 <= nums[i] <= 105
 */
public class NonDecreasingArray {


    public static void main(String[] args) {

        NonDecreasingArray obj = new NonDecreasingArray();
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
