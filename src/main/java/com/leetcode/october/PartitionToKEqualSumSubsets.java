package com.leetcode.october;

public class PartitionToKEqualSumSubsets {

    public static void main(String[] args) {

        PartitionToKEqualSumSubsets obj = new PartitionToKEqualSumSubsets();
        int[] ints = {18, 20, 39, 73, 96, 99, 101, 111, 114, 190, 207, 295, 471, 649, 700, 1037};
        boolean result = obj.canPartitionKSubsets(ints, 4);
        System.out.println(result);

    }

    public boolean canPartitionKSubsets(int[] nums, int k) {

        int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (k > n) return false;
        if (sum % k != 0) return false;

        sum /= k;
        boolean[] visited = new boolean[n];

        return backTrack(nums, 0, visited, n, k, 0, sum);

    }

    public boolean backTrack(int[] nums, int currSum, boolean[] visited, int n, int k, int subSets, int sum) {

        if (subSets == k) {
            for (boolean value : visited) {
                if (!value) {
                    System.out.println("Inside First if");
                    return false;
                }
            }
            return true;
        }
        if (subSets > k) {
            System.out.println("Inside Second if");
            return false;
        }
        if (currSum > sum) return false;

        if (currSum == sum) {
            return backTrack(nums, 0, visited, n, k, subSets + 1, sum);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && (currSum + nums[i]) <= sum) {
                visited[i] = true;
                boolean result = backTrack(nums, currSum + nums[i], visited, n, k, subSets, sum);
                if (result) return true;
                visited[i] = false;
            }
        }
        return false;
    }
}
