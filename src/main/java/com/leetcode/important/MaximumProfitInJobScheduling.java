package com.leetcode.important;

import java.util.Arrays;

/*
    We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i],
    obtaining a profit of profit[i].
    You're given the startTime, endTime and profit arrays, return the maximum profit you can
    take such that there are no two jobs in the subset with overlapping time range.
    If you choose a job that ends at time X you will be able to start another job that starts at time X.

 */
public class MaximumProfitInJobScheduling {

    public static void main(String[] args) {

        MaximumProfitInJobScheduling obj = new MaximumProfitInJobScheduling();
        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};
        int result = obj.jobScheduling(startTime, endTime, profit);
        System.out.println(result);
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int n = startTime.length;
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }

        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        int maxTime = arr[n - 1][1];

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int s = arr[i - 1][0];
            int e = arr[i - 1][1];
            int p = arr[i - 1][2];

            int index = findIndex(arr, 0, i - 1, s);
            p = p + dp[index + 1];
            dp[i] = Math.max(p, dp[i - 1]);
        }
        return dp[n];
    }

    public int findIndex(int[][] arr, int start, int end, int startTime) {

        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid][1] > startTime) {
                end = mid - 1;
            } else if (arr[mid][1] <= startTime) {
                start = mid + 1;
                result = mid;
            }
        }
        return result;
    }
}

/*
    TODO Complete This.


    Idea to Solve this problem is to use Dynamic Programming.
    This is kind of the variation of the Knapsack Problem.
    For Every Job you have the choice either to complete this job
    or not to complete the job.

    Here the constraint is that if you do this Job you will not be able
    to do any other job that has to be done in this time frame.

    So The Complete Idea is to use DP and the DP[i] will
    store the maximum Profit You can earn at ith Time.


    So For any Job.
        You can see if you wish to do this job then you can
        earn profit equal


 */