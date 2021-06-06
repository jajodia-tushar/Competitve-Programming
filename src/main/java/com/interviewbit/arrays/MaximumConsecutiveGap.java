package com.interviewbit.arrays;

import com.interviewbit.utils.ArrayUtils;

import java.util.Arrays;

public class MaximumConsecutiveGap {

    public static void main(String[] args) {
        MaximumConsecutiveGap obj = new MaximumConsecutiveGap();
        int[] ints = ArrayUtils.asArrays(1, 5, 10);
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
        // Original Answers has N - 1 Buckets.
        // But we are taking n buckets so simplify calculations.
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

                // We are finding the diff between Consecutive Numbers.
                // But we can't do minArr[i] - MaxArr[i - 1]
                // Because we are initializing Min and Max array and if there is no item in a particular
                // bucket it means that we should subtract the current min with previous to previous bucket max.
                // That's why we are using preMax variable and updating it only if current Max is not Integer.MIN_VALUE;
                int max1 = minArr[i] - preMax;
                maxDiff = Math.max(maxDiff, max1);
            }
            // Think Can there be a possibility that maxArr is MIN_VALUE and minArr is populated.
            // Never. So we are able to do this. Else We won't be able to do this.
            if (maxArr[i] != Integer.MIN_VALUE) {
                preMax = maxArr[i];
            }
        }
        return maxDiff;
    }
}

/*

    The idea is simple and described in the copy very well.
    But the changes that I have made is instead of taking n - 1 buckets.
    we are taking n buckets.
    So that we don't have to handle the Max case in different values.


 */
