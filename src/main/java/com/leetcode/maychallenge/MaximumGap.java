package com.leetcode.maychallenge;

import java.util.Arrays;

public class MaximumGap {

    public static void main(String[] args) {
        MaximumGap obj = new MaximumGap();
        int[] ints = {1, 2, 5, 8, 9, 100};
        int result = obj.maximumGap(ints);
        System.out.println(result);
    }

    public int maximumGap(int[] nums) {

        int n = nums.length;
        if (n < 2) return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        float gap = (float) (max - min) / (float) (n - 1);
        int[] minArr = new int[n];
        int[] maxArr = new int[n];

        Arrays.fill(minArr, Integer.MAX_VALUE);
        Arrays.fill(maxArr, Integer.MIN_VALUE);

        for (int i = 0; i < n; i++) {
            int currentNumber = nums[i];
            int bucketIndex = (int) Math.floor((currentNumber - min) / gap);
            minArr[bucketIndex] = Math.min(minArr[bucketIndex], currentNumber);
            maxArr[bucketIndex] = Math.max(maxArr[bucketIndex], currentNumber);
        }

        int maxDiff = 0;
        int preMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (preMax != Integer.MIN_VALUE && minArr[i] != Integer.MAX_VALUE) {
                int max1 = minArr[i] - preMax;
                maxDiff = Math.max(maxDiff, max1);
            }
            if (maxArr[i] != Integer.MIN_VALUE) {
                preMax = maxArr[i];
            }
        }
        return maxDiff;
    }
}
