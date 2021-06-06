package com.leetcode.maychallenge;


/*
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.



Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2


Constraints:
1 <= nums.length <= 1000
0 <= nums[i] <= 105
 */
public class JumpGameII {

    public static void main(String[] args) {
        JumpGameII obj = new JumpGameII();
        int[] ints = {2, 3, 0, 1, 4};
        int result = obj.jump(ints);
        System.out.println(result);
    }

    public int jump(int[] nums) {
        int maxReachableIndex = 0;
        int count = 0;
        int currPosition = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int possible = i + nums[i];
            if (maxReachableIndex < possible) {
                maxReachableIndex = possible;
            }
            if (currPosition == i) {
                currPosition = maxReachableIndex;
                count++;
            }
        }
        return count;
    }
}
