package com.interviewbit.twopointer;

import com.interviewbit.utils.ArrayUtils;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater obj = new ContainerWithMostWater();
        System.out.println(obj.maxArea(ArrayUtils.asArrays(1, 5, 4, 3)));
    }

    public int maxArea(int[] A) {
        int i = 0;
        int n = A.length - 1;
        if( n <= 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        while( i < n){
            int diff = n - i;
            int volume = diff * Math.min(A[i],A[n]);
            max = Math.max(volume,max);

            if( A[i] > A[n]){
                n--;
            }
            else{
                i++;
            }
        }
        return max;
    }
}
