package com.interviewbit.dp.kadene;

import com.interviewbit.utils.ArrayUtils;

public class MaxProductSubarray {

    public static void main(String[] args) {

        MaxProductSubarray obj = new MaxProductSubarray();
        int[] ints = ArrayUtils.asArrays(-1, -2, -3, -4);
        int result = obj.maxProductSimplified(ints);
        System.out.println(result);
    }

    public int maxProduct(final int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        max[0] = min[0] = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                max[i] = Math.max(nums[i], max[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
            } else {
                max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
            }

            result = Math.max(result, max[i]);
        }
        ArrayUtils.printArray(max);
        ArrayUtils.printArray(min);

        return result;
    }

    public int maxProductSimplified(final int[] nums) {
        int maxTillNow = nums[0];
        int minTillNow = nums[0];

        int result = nums[0];

        for(int i=1; i<nums.length; i++){
            if(nums[i]>0){
                int maxTemp = Math.max(nums[i], maxTillNow*nums[i]);
                int minTemp = Math.min(nums[i], minTillNow*nums[i]);
                maxTillNow = maxTemp;
                minTillNow = minTemp;
            }else{
                int maxTemp = Math.max(nums[i], minTillNow*nums[i]);
                int minTemp = Math.min(nums[i], maxTillNow*nums[i]);
                maxTillNow = maxTemp;
                minTillNow = minTemp;
            }

            result = Math.max(result, maxTillNow);
        }

        return result;
    }
}
