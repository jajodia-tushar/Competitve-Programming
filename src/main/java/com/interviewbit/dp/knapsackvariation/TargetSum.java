package com.interviewbit.dp.knapsackvariation;

/*

    You are given an integer array nums and an integer target.
    You want to build an expression out of nums by adding one of the symbols '+'
        and '-' before each integer in nums and then concatenate all the integers.
    For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and
        concatenate them to build the expression "+2-1".
    Return the number of different expressions that you can build, which evaluates to target.

 */

// See You are not allowed to not take any particular number.
// You have to take all the numbers.

import com.interviewbit.utils.ArrayUtils;

import java.util.Arrays;

public class TargetSum {

    public static void main(String[] args) {
        TargetSum obj = new TargetSum();
        int[] ints = ArrayUtils.asArrays(1, 1, 1, 1, 1);
        int result = obj.findTargetSumWays(ints, 3);
        System.out.println(result);
    }

    public int findTargetSumWays(int[] arr, int target) {

        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int[][] dp = new int[n + 1][2 * sum + 1];
        for (int[] a : dp) Arrays.fill(a, -1);
        int result = calculate(arr, 0, 0, target, dp, sum);
        ArrayUtils.printArray(dp);
        return result;
    }

    public int calculate(int[] nums, int index, int currSum, int target, int[][] memo, int total) {
        if (index == nums.length) {
            if (currSum == target)
                return 1;
            else
                return 0;
        } else {
            if (memo[index][currSum + total] != -1) {
                return memo[index][currSum + total];
            }
            int add = calculate(nums, index + 1, currSum + nums[index], target, memo, total);
            int subtract = calculate(nums, index + 1, currSum - nums[index], target, memo, total);
            memo[index][currSum + total] = add + subtract;
            return memo[index][currSum + total];
        }
    }


}
