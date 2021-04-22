package com.interviewbit.dp.lcsvariation;

import com.interviewbit.utils.ArrayUtils;

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {

        LongestIncreasingSubSequence obj = new LongestIncreasingSubSequence();
        int[] ints = ArrayUtils.asArrays(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15);
        int result = obj.LIS(ints);
        System.out.println(result);

    }

    public int LIS(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];

        int totalMax = 0;

        for(int i = 0; i < dp.length; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if( arr[i] > arr[j]){
                    max = Math.max(max,dp[j]);
                }
            }
            dp[i] = max + 1;
            totalMax = Math.max(totalMax,dp[i]);
        }
        return totalMax;
    }

    public int[] getLIS(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];

        for(int i = 0; i < dp.length; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if( arr[i] > arr[j]){
                    max = Math.max(max,dp[j]);
                }
            }
            dp[i] = max + 1;
        }
        return dp;
    }

    public int[] getLDS(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];

        for(int i = 0; i < dp.length; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if( arr[i] < arr[j]){
                    max = Math.max(max,dp[j]);
                }
            }
            dp[i] = max + 1;
        }
        return dp;
    }

}
