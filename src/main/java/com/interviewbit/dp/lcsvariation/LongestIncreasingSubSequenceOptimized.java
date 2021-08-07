package com.interviewbit.dp.lcsvariation;

public class LongestIncreasingSubSequenceOptimized {
    public static void main(String[] args) {
        LongestIncreasingSubSequenceOptimized obj = new LongestIncreasingSubSequenceOptimized();
        int[] arr = new int[]{1,2,3,5,4};
        int result = obj.lengthOfLIS(arr);
        System.out.println(result);
    }


    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int len = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > dp[len - 1]) {
                dp[len] = nums[i];
                len += 1;
            } else {
                int index = getCeilingIndex(nums[i], 0, len - 1, dp);
                dp[index] = nums[i];
            }
        }

        return len;
    }

    public int getCeilingIndex(int value, int low, int high, int[] arr) {

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }
}
